package test.debug.subject;

public interface SubjectsMgr {
	void add(Subject v) throws DuplicatedException;
	Subject[] search();
	Subject search(String name) throws NotFoundException;
}