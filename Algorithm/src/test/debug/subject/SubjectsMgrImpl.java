package test.debug.subject;

import java.util.Arrays;

import javax.sql.rowset.FilteredRowSet;

public class SubjectsMgrImpl implements SubjectsMgr {
	private Subject[] subjects;
	private int index;
	
	public SubjectsMgrImpl() {
		subjects=new Subject[100];		
	}
	
	@Override
	public void add(Subject s) throws DuplicatedException{
		try {
			search(s.getName());
			throw new DuplicatedException(s.getName()+": 등록된 과목입니다.");
		} catch (NotFoundException e) {
			subjects[index++]=s;
		}
	}
	@Override
	public Subject[] search() {
		Subject[] s=new Subject[index];
		for(int i=0;i<index;i++) {
			s[i] =subjects[i];
		}
		return s;
	}
	
	@Override
	public Subject search(String name) throws NotFoundException{
		for(int i=0; i<index; i++) {
			if(subjects[i].getName().equals(name)) return subjects[i];
		}
		throw new NotFoundException(name+": 미등록 과목입니다.");
	}
}
