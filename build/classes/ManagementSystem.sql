--�������ݿ�
CREATE DATABASE  IF NOT EXISTS ManagementSystem DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
--�û��� --����Ա
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

INSERT INTO `t_user` VALUES ('666666', 'admin', '123456', '��', '13988888888', '2019-04-03 15:21:26', '1', null);
--רҵ��
CREATE TABLE `t_Major` (
  `maid` varchar(32) NOT NULL,
  `major_name` varchar(32) NOT NULL,
  `DepartmentID` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--ϵ����
CREATE TABLE `t_Department` (
  `DepartmentID` varchar(32) NOT NULL,
  `Department_name` varchar(32) NOT NULL,
  PRIMARY KEY (`DepartmentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--��ʦ��
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
--ѧ����
CREATE TABLE `t_StudentUnion` (
  `Un_ID` varchar(32) NOT NULL,
  `Un_name` varchar(32) NOT NULL,
  PRIMARY KEY (`Un_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--�γ̱�
CREATE TABLE `t_Course` (
  `CourseID` varchar(32) NOT NULL,
  `CourseName` varchar(32) NOT NULL,
  `CreDits` varchar(32) NOT NULL,
   `maid` varchar(32) NOT NULL,
  PRIMARY KEY (`CourseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--�༶��
CREATE TABLE `tb_Class` (
  `classId` varchar(32) NOT NULL,
  `class_name` varchar(32) NOT NULL,
  `Num` varchar(32) NOT NULL,
   `maid` varchar(32) NOT NULL,
   `DepartmentID` varchar(32) NOT NULL,
   `CourseID` varchar(32) NOT NULL,
  PRIMARY KEY (`classId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--��ʦ�༶�м��
CREATE TABLE `t_tealass` (
  `tealass_ID` varchar(32) NOT NULL,
  `classId` varchar(32) NOT NULL,
  `TeacherId`` varchar(32) NOT NULL,
  `CourseID`` varchar(32) NOT NULL,
  PRIMARY KEY (`tealass_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--����ѡ�޿κ�ѧ�����м��
CREATE TABLE `t_sportStu` (
  `sportStu_ID` varchar(32) NOT NULL,
  `Un_ID` varchar(32) NOT NULL,
  `StuId`` varchar(32) NOT NULL,
  PRIMARY KEY (`sportStu_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;