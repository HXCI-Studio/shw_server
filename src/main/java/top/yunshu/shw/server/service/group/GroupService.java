package top.yunshu.shw.server.service.group;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import top.yunshu.shw.server.entity.Group;
import top.yunshu.shw.server.exception.NoSuchFiledValueException;

/**
 * 群组服务
 *
 * @author shulu
 * @author itning
 */
public interface GroupService {
    /**
     * 获取学生所在的所有群组
     *
     * @param studentNumber 学生学号
     * @param pageable      {@link Pageable}
     * @return 学生加入群组集合
     */
    Page<Group> findStudentAllGroups(String studentNumber, Pageable pageable);

    /**
     * 通过邀请码加入群组
     *
     * @param code      邀请码
     * @param studentId 学生ID
     * @return 返回加入成功的群组
     * @throws NoSuchFiledValueException 邀请码不存在
     */
    Group joinGroup(String code, String studentId);

    /**
     * 学生退出群组
     *
     * @param groupId   要退出的群组ID
     * @param studentId 学生ID
     * @throws NoSuchFiledValueException 群组ID不存在
     */
    void dropOutGroup(String groupId, String studentId);

    /**
     * 获取教师所创建所有群组
     *
     * @param teacherNumber 教师ID
     * @param pageable      {@link Pageable}
     * @return 群组集合
     */
    Page<Group> findTeacherAllGroups(String teacherNumber, Pageable pageable);

    /**
     * 创建新群组
     *
     * @param groupName   新建群组名
     * @param teacherId   教师ID
     * @param teacherName 教师姓名
     * @return 返回创建后群组
     */
    Group createGroup(String groupName, String teacherName, String teacherId);

    /**
     * 删除已有群组
     *
     * @param teacherNumber 教师ID
     * @param id            群组ID
     */
    void deleteGroup(String id, String teacherNumber);

    /**
     * 修改已有群组名
     *
     * @param id            需要修改的群组ID
     * @param name          新群组名
     * @param teacherNumber 教师ID
     * @return 修改后的群组
     * @throws NoSuchFiledValueException Id不存在
     */
    Group updateGroup(String id, String name, String teacherNumber);

    /**
     * 根据群ID查询群名称
     *
     * @param groupId 群ID
     * @return 群名称
     * @throws NoSuchFiledValueException Id不存在
     */
    String findGroupNameByGroupId(String groupId);

    /**
     * 根据群ID查询群
     *
     * @param groupId 群ID
     * @return 教师名
     * @throws NoSuchFiledValueException Id不存在
     */
    String findTeacherNameById(String groupId);

    /**
     * 检查教师是否有群组
     *
     * @param teacherNumber 教师ID
     * @return 有返回<code>true</code>
     */
    boolean isHaveAnyGroup(String teacherNumber);

}
