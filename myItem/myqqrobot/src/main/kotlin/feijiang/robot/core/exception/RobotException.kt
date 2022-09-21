package feijiang.robot.core.exception

/**
 * @author feijiang
 */
open class RobotException : RuntimeException {
    constructor()
    constructor(message: String?) : super(message)
}