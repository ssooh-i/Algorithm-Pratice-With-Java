package test.debug.person;

import java.util.List;

public interface PersonMgr {
	void add(Person person);
	List<Person> search();
	Person search(String name);
	void delete(String name);
	void load();
	void save();
}