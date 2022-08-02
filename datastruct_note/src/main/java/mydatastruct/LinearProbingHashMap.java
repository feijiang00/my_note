package mydatastruct;

import java.util.Arrays;
import java.util.Map;

/**
 * 基于线性探测法的散列表简单实现
 *
 * @param <K> key类型
 * @param <V> value类型
 */
public class LinearProbingHashMap<K, V> {

    /**
     * 存储节点数据的数组
     */
    transient Entry<K, V>[] table;

    /**
     * 存储的节点对象
     *
     * @param <K>
     * @param <V>
     */
    private static class Entry<K, V> implements Map.Entry<K, V> {
        /**
         * 保存hash值,避免重复计算
         */
        final int hash;
        /**
         * key值
         */
        final K key;
        /**
         * value值
         */
        V value;

        /**
         * 构造器
         *
         * @param hash
         * @param key
         * @param value
         */
        private Entry(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        /*@Override
        public final String toString() {

            return hash + "=" + key + "=" + value;
        }*/
        @Override
        public final String toString() {

            return key + "=" + value;
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public int hashCode() {
            return hash;
        }
    }

    /**
     * 散列表的容量,初始为16
     */
    private int capacity = 16;
    /**
     * 散列表节点数量
     */
    private int size;

    /**
     * 空构造器,并不会初始化内部数组
     */
    public LinearProbingHashMap() {
    }

    /**
     * 插入
     *
     * @param key   k
     * @param value v
     */
    public V put(K key, V value) {
        //初始化
        if (table == null) {
            table = new Entry[capacity];
        }
        //扩容,这里判断元素数量大于等于0.75*capacity
        if (size >= capacity * 0.75) {
            resize(2 * capacity);
        }
        int hash = hash(key);
        //计算应该插入的数组元素下标
        int position = hash & (capacity - 1);
        //插入逻辑,总会成功
        while (true) {
            if (table[position] == null) {
                table[position] = new Entry<>(hash, key, value);
                size++;
                break;
                //判断是否是重复的key,这里使用hash值和==判断
            } else if (hash == table[position].hashCode() && table[position].getKey() == key) {
                return table[position].setValue(value);
            }
            position = nextIndex(position, capacity);
        }
        return null;
    }

    /**
     * 查找
     *
     * @param key 要查找的key
     * @return 查找到的value
     */
    public V get(K key) {
        if (table == null) {
            return null;
        }
        //计算出key对应的数组位置
        int position = hash(key) & (capacity - 1);
        //如果该位置不为null,则开始查找连续的元素
        if (table[position] != null) {
            do {
                if (table[position].getKey() == key) {
                    return table[position].getValue();
                }
                position = nextIndex(position, capacity);
            } while (table[position] != null);
        }
        return null;
    }


    /**
     * 删除元素
     *
     * @param key 查找的元素
     * @return 被删除的元素value;null不代表不是被删除的value
     */
    public V delete(K key) {
        if (table == null) {
            return null;
        }
        //计算出key对应的数组位置
        int position = hash(key) & (capacity - 1);
        V value;
        //如果该位置不为null,则开始查找连续的元素
        if (table[position] != null) {
            do {
                if (table[position].getKey() == key) {
                    //删除元素
                    value = table[position].getValue();
                    table[position] = null;
                    size--;
                    //将后面的连续的元素全部重新插入
                    position = nextIndex(position, capacity);
                    Entry<K, V> positionEntry;
                    while ((positionEntry = table[position]) != null) {
                        table[position] = null;
                        size--;
                        put(positionEntry.getKey(), positionEntry.getValue());
                        position = nextIndex(position, capacity);
                    }
                    return value;
                }
                position = nextIndex(position, capacity);
            } while (table[position] != null);
        }
        return null;
    }

    public int size() {
        return size;
    }

    /**
     * 获取hash值,不是直接取hash值,而是借鉴了HashMap的扰动算法,这样可以让元素分布更加均匀
     *
     * @param key k
     * @return hash值
     */
    private int hash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * 扩容
     *
     * @param newCapacity 新容量
     */
    private void resize(int newCapacity) {
        if (newCapacity <= 0) {
            throw new StackOverflowError("容量超出最大容量");
        }
        this.capacity = newCapacity;
        Entry<K, V>[] oldTab = table;
        table = new Entry[capacity];
        for (Entry<K, V> e : oldTab) {
            if (e != null) {
                int position = e.hashCode() & (capacity - 1);
                while (table[position] != null) {
                    position = nextIndex(position, capacity);
                }
                table[position] = e;
            }
        }
    }

    /**
     * 下一个位置
     *
     * @param i   当前位置
     * @param len 数组长度
     * @return 下一个位置, 此处包含循环的逻辑循环
     */
    private static int nextIndex(int i, int len) {
        return ((i + 1 < len) ? i + 1 : 0);
    }


    @Override
    public String toString() {
        return "LinearProbingHashST{" +
                "table=" + Arrays.toString(table) +
                '}';
    }

}




