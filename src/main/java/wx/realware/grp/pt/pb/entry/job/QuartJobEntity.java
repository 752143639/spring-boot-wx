package wx.realware.grp.pt.pb.entry.job;

import wx.realware.grp.pt.pb.interconfig.Column;
import wx.realware.grp.pt.pb.interconfig.Table;

import java.io.Serializable;

@Table(value = "wx_auto_task")
public class QuartJobEntity implements Serializable {
    /**
     * uuid
     * 主键
     */

    @Column(value = "job_id")
    private  String job_id;
    /**
     * 自动任务名称
     */
    @Column(value = "job_name")
    private  String job_name;
    /**
     * 自动任务类型
     */
    @Column(value = "job_type")
    private  int job_type;
    /**
     * 自动任务类路径
     */
    @Column(value = "class_name")
    private  String class_name;
    /**
     * 是否启用
     * 0不启用
     * 1启用
     */
    @Column(value = "job_enabled")
    private  int job_enabled;
    /**
     * quart时间表达式
     */
    @Column(value = "job_time")
    private  String job_time;

    /**
     *间隔执行时间(ms)
     */
    @Column(value = "job_interval")
    private  int job_interval;
    /**
     *重复执行次数
     */
    @Column(value = "repearcount")
    private  int repearcount;
    /**
     *延迟时间
     */
    @Column(value = "delaytime")
    private  int delaytime;

    /**
     *注解
     */
    @Column(value = "remark")
    private  long remark;

    /**
     * 执行类型  同一个库的时候  1： 只有一台机器能执行 2：多台机器执行
     */
    private int exe_type;
    /**
     * 最后一次操作的时间
     */
    private String last_op_date;

    /**
     * 是否当前正在执行(针对于只有一个机器能执行的任务)
     */
    private int is_cur_exe;

    /**
     * 最大超时时间（单位： 分钟）
     */
    private int max_exe_time;


    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public int getJob_type() {
        return job_type;
    }

    public void setJob_type(int job_type) {
        this.job_type = job_type;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public int getJob_enabled() {
        return job_enabled;
    }

    public void setJob_enabled(int job_enabled) {
        this.job_enabled = job_enabled;
    }

    public String getJob_time() {
        return job_time;
    }

    public void setJob_time(String job_time) {
        this.job_time = job_time;
    }

    public int getJob_interval() {
        return job_interval;
    }

    public void setJob_interval(int job_interval) {
        this.job_interval = job_interval;
    }

    public int getRepearcount() {
        return repearcount;
    }

    public void setRepearcount(int repearcount) {
        this.repearcount = repearcount;
    }

    public int getDelaytime() {
        return delaytime;
    }

    public void setDelaytime(int delaytime) {
        this.delaytime = delaytime;
    }

    public long getRemark() {
        return remark;
    }

    public void setRemark(long remark) {
        this.remark = remark;
    }

    public int getExe_type() {
        return exe_type;
    }

    public void setExe_type(int exe_type) {
        this.exe_type = exe_type;
    }

    public String getLast_op_date() {
        return last_op_date;
    }

    public void setLast_op_date(String last_op_date) {
        this.last_op_date = last_op_date;
    }

    public int getIs_cur_exe() {
        return is_cur_exe;
    }

    public void setIs_cur_exe(int is_cur_exe) {
        this.is_cur_exe = is_cur_exe;
    }

    public int getMax_exe_time() {
        return max_exe_time;
    }

    public void setMax_exe_time(int max_exe_time) {
        this.max_exe_time = max_exe_time;
    }
}
