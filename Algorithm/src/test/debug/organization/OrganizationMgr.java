package test.debug.organization;

import java.util.List;

public interface OrganizationMgr {
	List<Organization> search();
	Organization search(String o);
}