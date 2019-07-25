--创建数据库
CREATE DATABASE  IF NOT EXISTS ManagementSystem DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
--用户表 --管理员
CREATE TABLE `t_user` (
  `id` varchar(32) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `mobile` varchar(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `type` tinyint(1) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `t_user` VALUES ('666666', 'admin', '123456', '男', '13988888888', '2019-04-03 15:21:26', '1', null);
--专业表
CREATE TABLE `t_Major` (
  `maid` varchar(32) NOT NULL,
  `major_name` varchar(32) NOT NULL,
  `DepartmentID` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--系部表
CREATE TABLE `t_Department` (
  `DepartmentID` varchar(32) NOT NULL,
  `Department_name` varchar(32) NOT NULL,
  PRIMARY KEY (`DepartmentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--教师表
CREATE TABLE `t_Teacher` (
  `TeacherId` varchar(32) NOT NULL,
  `TeacherName` varchar(32) NOT NULL,
  `Sex` varchar(32) NOT NULL,
  `BirthDate` varchar(32) NOT NULL,
  `PoliticaFace` varchar(32) NOT NULL,
  `Native` varchar(32) NOT NULL,
  `TePhone` varchar(32) NOT NULL,
  `IDNum` varchar(32) NOT NULL,
  `AdmissionTime` varchar(32) NOT NULL,
  `HighesDegree` varchar(32) NOT NULL,
  `Position` varchar(32) NOT NULL,
  `photo` varchar(32) ,
  `National` varchar(32) NOT NULL,
  `DepartmentID` varchar(32) NOT NULL,
  PRIMARY KEY (`TeacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--学生会
CREATE TABLE `t_StudentUnion` (
  `Un_ID` varchar(32) NOT NULL,
  `Un_name` varchar(32) NOT NULL,
  PRIMARY KEY (`Un_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--课程表
CREATE TABLE `t_Course` (
  `CourseID` varchar(32) NOT NULL,
  `CourseName` varchar(32) NOT NULL,
  `CreDits` varchar(32) NOT NULL,
   `maid` varchar(32) NOT NULL,
  PRIMARY KEY (`CourseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--班级表
CREATE TABLE `tb_Class` (
  `classId` varchar(32) NOT NULL,
  `class_name` varchar(32) NOT NULL,
  `Num` varchar(32) NOT NULL,
   `maid` varchar(32) NOT NULL,
   `DepartmentID` varchar(32) NOT NULL,
   `CourseID` varchar(32) NOT NULL,
  PRIMARY KEY (`classId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--教师班级中间表
CREATE TABLE `t_tealass` (
  `tealass_ID` varchar(32) NOT NULL,
  `classId` varchar(32) NOT NULL,
  `TeacherId`` varchar(32) NOT NULL,
  `CourseID`` varchar(32) NOT NULL,
  PRIMARY KEY (`tealass_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--体育选修课和学生的中间表
CREATE TABLE `t_sportStu` (
  `sportStu_ID` varchar(32) NOT NULL,
  `Un_ID` varchar(32) NOT NULL,
  `StuId`` varchar(32) NOT NULL,
  PRIMARY KEY (`sportStu_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;