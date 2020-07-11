package com.hyp.weixinpage.pojo.modal;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "weixin_feedback_email")
public class WeixinFeedbackEmail {

    public static WeixinFeedbackEmail init() {
        WeixinFeedbackEmail weixinFeedbackEmail = new WeixinFeedbackEmail();
        weixinFeedbackEmail.setSendTo("");
        weixinFeedbackEmail.setSendFrom("");
        weixinFeedbackEmail.setCreateTime(new Date());
        weixinFeedbackEmail.setUpdateTime(new Date());
        weixinFeedbackEmail.setEmailType(0);
        weixinFeedbackEmail.setSendTime(new Date());
        weixinFeedbackEmail.setSendType(0);
        weixinFeedbackEmail.setSendStatus(0);
        weixinFeedbackEmail.setSyncStatus(0);
        weixinFeedbackEmail.setEmailTitle("");
        weixinFeedbackEmail.setSendToName("");
        weixinFeedbackEmail.setEmailContent("");
        return weixinFeedbackEmail;
    }

    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 发送给谁
     */
    @Column(name = "send_to")
    private String sendTo;

    /**
     * 发送人
     */
    @Column(name = "send_from")
    private String sendFrom;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 邮件类型 0默认我方发送 1用户提交
     */
    @Column(name = "email_type")
    private Integer emailType;

    /**
     * 发送时间
     */
    @Column(name = "send_time")
    private Date sendTime;

    /**
     * 发送类型 0即刻发送 1定时发送
     */
    @Column(name = "send_type")
    private Integer sendType;

    /**
     * 当前邮件状态 0为默认值未发送 1已发送
     */
    @Column(name = "send_status")
    private Integer sendStatus;

    /**
     * 邮件同步状态 0为未同步 1已同步
     */
    @Column(name = "sync_status")
    private Integer syncStatus;

    /**
     * 邮件的标题
     */
    @Column(name = "email_title")
    private String emailTitle;

    /**
     * 邮件接收人名称
     */
    @Column(name = "send_to_name")
    private String sendToName;

    /**
     * 邮件的内容
     */
    @Column(name = "email_content")
    private String emailContent;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取发送给谁
     *
     * @return send_to - 发送给谁
     */
    public String getSendTo() {
        return sendTo;
    }

    /**
     * 设置发送给谁
     *
     * @param sendTo 发送给谁
     */
    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    /**
     * 获取发送人
     *
     * @return send_from - 发送人
     */
    public String getSendFrom() {
        return sendFrom;
    }

    /**
     * 设置发送人
     *
     * @param sendFrom 发送人
     */
    public void setSendFrom(String sendFrom) {
        this.sendFrom = sendFrom;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取邮件类型 0默认我方发送 1用户提交
     *
     * @return email_type - 邮件类型 0默认我方发送 1用户提交
     */
    public Integer getEmailType() {
        return emailType;
    }

    /**
     * 设置邮件类型 0默认我方发送 1用户提交
     *
     * @param emailType 邮件类型 0默认我方发送 1用户提交
     */
    public void setEmailType(Integer emailType) {
        this.emailType = emailType;
    }

    /**
     * 获取发送时间
     *
     * @return send_time - 发送时间
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * 设置发送时间
     *
     * @param sendTime 发送时间
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * 获取发送类型 0即刻发送 1定时发送
     *
     * @return send_type - 发送类型 0即刻发送 1定时发送
     */
    public Integer getSendType() {
        return sendType;
    }

    /**
     * 设置发送类型 0即刻发送 1定时发送
     *
     * @param sendType 发送类型 0即刻发送 1定时发送
     */
    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }

    /**
     * 获取当前邮件状态 0为默认值未发送 1已发送
     *
     * @return send_status - 当前邮件状态 0为默认值未发送 1已发送
     */
    public Integer getSendStatus() {
        return sendStatus;
    }

    /**
     * 设置当前邮件状态 0为默认值未发送 1已发送
     *
     * @param sendStatus 当前邮件状态 0为默认值未发送 1已发送
     */
    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    /**
     * 获取邮件同步状态 0为未同步 1已同步
     *
     * @return sync_status - 邮件同步状态 0为未同步 1已同步
     */
    public Integer getSyncStatus() {
        return syncStatus;
    }

    /**
     * 设置邮件同步状态 0为未同步 1已同步
     *
     * @param syncStatus 邮件同步状态 0为未同步 1已同步
     */
    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    /**
     * 获取邮件的标题
     *
     * @return email_title - 邮件的标题
     */
    public String getEmailTitle() {
        return emailTitle;
    }

    /**
     * 设置邮件的标题
     *
     * @param emailTitle 邮件的标题
     */
    public void setEmailTitle(String emailTitle) {
        this.emailTitle = emailTitle;
    }

    /**
     * 获取邮件接收人名称
     *
     * @return send_to_name - 邮件接收人名称
     */
    public String getSendToName() {
        return sendToName;
    }

    /**
     * 设置邮件接收人名称
     *
     * @param sendToName 邮件接收人名称
     */
    public void setSendToName(String sendToName) {
        this.sendToName = sendToName;
    }

    /**
     * 获取邮件的内容
     *
     * @return email_content - 邮件的内容
     */
    public String getEmailContent() {
        return emailContent;
    }

    /**
     * 设置邮件的内容
     *
     * @param emailContent 邮件的内容
     */
    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }
}