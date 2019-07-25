package com.hwua.ManagementSystem.service;
import java.util.List;

import com.hwua.ManagementSystem.entity.StudentUnion;
public interface StudentUnionservice {
	int create(StudentUnion studentUnion);
	int update(StudentUnion StudentUnion);
	int delete(String id);
	StudentUnion findById(String id);
	List<StudentUnion> findAll();
	StudentUnion findBystudentUnionname(String StudentUnionname);
}
