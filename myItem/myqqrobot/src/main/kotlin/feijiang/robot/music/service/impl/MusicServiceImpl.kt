package feijiang.robot.music.service.impl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import feijiang.robot.core.common.invoke
import feijiang.robot.core.common.logger
import feijiang.robot.music.entity.MusicInfo
import feijiang.robot.music.service.BaseMusicService
import feijiang.robot.music.service.MusicSearchService
import java.util.*
import java.util.concurrent.ExecutionException
import java.util.stream.Collectors

/**
 * @author feijiang
 */
@Service
class MusicServiceImpl(
    override var musicSearchServiceList: ArrayList<MusicSearchService>?,
    @Value("\${music.autoLogin}") private val autoLogin: Boolean,
) : BaseMusicService {

    override fun search(name: String): List<MusicInfo> {
        initServices()
        for (service in BaseMusicService.SearchService.values()) {
            val musicInfoList: List<MusicInfo>? = searchMusic(name, service)
            if (musicInfoList != null) {
                return musicInfoList
            }
            logger { service.name + "搜索返回空" }
        }
        return emptyList()
    }

    override fun search(name: String, service: BaseMusicService.SearchService): List<MusicInfo> {
        initServices()
        val list: List<MusicInfo>? = searchMusic(name, service)
        return list ?: emptyList()
    }

    private fun searchMusic(name: String, service: BaseMusicService.SearchService): List<MusicInfo>? {
        val musicSearchService: MusicSearchService = service.musicSearchServiceClass
        val musicInfoList: List<MusicInfo> = try {
            musicSearchService.search(name)
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
            return null
        } catch (e: ExecutionException) {
            return null
        }
        if (musicInfoList.isEmpty()) {
            return null
        }
        for (musicInfo in musicInfoList) {
            musicInfo.type = service
        }
        //        val list: List<MusicInfo> = musicInfoService.list(
        //            LambdaQueryWrapper<MusicInfo>().`in`(
        //                MusicInfo::getMid,
        //                musicInfoList.stream().map<Any>(MusicInfo::getMid).collect(Collectors.toList())
        //            )
        //        )
        //        if (list.size != musicInfoList.size) {
        //            val collect = list.stream().map<Any>(MusicInfo::getMid).collect(Collectors.toList<Any>())
        //            val map: Map<Boolean, List<MusicInfo>> = musicInfoList.stream().collect(
        //                Collectors.groupingBy<MusicInfo, Boolean>(
        //                    Function<MusicInfo, Boolean> { i: MusicInfo -> collect.contains(i.getMid()) })
        //            )
        //            musicInfoService.saveBatch(map[java.lang.Boolean.FALSE])
        //            musicInfoService.updateBatchById(map[java.lang.Boolean.TRUE])
        //        }
        return musicInfoList
    }

    override fun run(vararg args: String) {
        initServices()
        autoLogin {
            for (service in BaseMusicService.SearchService.values()) {
                CoroutineScope(Dispatchers.Default).launch {
                    val loginResult = service.musicSearchServiceClass.login()
                    logger { "${service.name} login ${if (loginResult) "success" else "fail"}." }
                }
            }
        }
    }

    private fun initServices() {
        if (musicSearchServiceList == null) {
            musicSearchServiceList = ArrayList()
            for (service in Arrays.stream(BaseMusicService.SearchService.values())
                .sorted(Comparator.comparingInt(BaseMusicService.SearchService::priority))
                .collect(Collectors.toList())) {
                musicSearchServiceList!!.add(service.musicSearchServiceClass)
            }
        }
    }
}