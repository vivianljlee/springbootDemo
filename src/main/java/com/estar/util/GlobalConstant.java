package com.estar.util;

public class GlobalConstant {
	// 超级管理员角色
	public final static String ROLE_SUPERADMIN = "SuperAdmin";
	// 校级管理员角色
	public final static String ROLE_SCHOOLADMIN = "SchoolAdmin";
	// 老师角色
	public final static String ROLE_TEACHER = "Teacher";
	// 学生角色
	public final static String ROLE_STUDENT = "Student";
	// 家长角色
	public final static String ROLE_PARENT = "Parent";
	// 专家角色
	public final static String ROLE_EXPERT = "Expert";
	// 教育局角色
	public final static String ROLE_BUREAU = "Bureau";
	// 联通角色
	public final static String ROLE_LIANTONG = "LianTong";
	// 通知类别（2通知，1作业,3站内信）
	public final static int letterType = 2;
	public final static int HOMEWORKTYPE = 1;
	public final static int STATIONLETTER = 3;
	// 组织机构关联表分类(2年级)
	public final static int ORGGRADETYPE = 2;
	// 通知阅读状态(1未读,2已读)
	public final static int READ = 2;
	public final static int UNREAD = 1;
	// 用户分类(a教师,b学生,c家长,d学校管理员,e运营商,f教育局,g专家,h超管)
	public final static String USER_TEACHER = "a";
	public final static String USER_STUDENT = "b";
	public final static String USER_PARENT = "c";
	public final static String USER_MANGER = "d";
	public final static String USER_EXPERTS="g";
	public final static String USER_BUREAU_OF_EDUCATION="f";
	public final static String USER_OPERATORS="e";
	public final static String USER_SUPER_MANGER = "h";
	// 试题分类(1是客观题,2是主观题)
	public final static int QUESTION_STORT_OBJECTIVE = 1;
	public final static int QUESTION_STORT_SUBJECTIVE = 2;
	// 试题类型(1单选，2多选，3填空，4判断，5问答)
	public final static int QUESTION_TYPE_RADIO = 1;
	public final static int QUESTION_TYPE_MULTIPLE_CHOICE = 2;
	public final static int QUESTION_TYPE_FILL_BLANK = 3;
	public final static int QUESTION_TYPE_JUDGE = 4;
	public final static int QUESTION_TYPE_ANSWER_QUESTION = 5;
	// 试题等级(1基础，2提高，3拓展)
	public final static int QUESTION_LEVELS_BASE = 1;
	public final static int QUESTION_LEVELS_IMPROVE = 2;
	public final static int QUESTION_LEVELS_EXPAND = 3;
    //是否发送短信通知1发送2不发送
	public final static int SENT_MESSAGE=1;
	public final static int NOT_SENT_MESSAGE=2;
}
