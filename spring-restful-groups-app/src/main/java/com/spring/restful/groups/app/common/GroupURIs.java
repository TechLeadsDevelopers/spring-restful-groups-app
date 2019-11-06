package com.spring.restful.groups.app.common;

public interface GroupURIs {
	String GROUP_API_ROOT = "/groups";
	String GROUP_API_ROOT_BATCH = GROUP_API_ROOT + "/" + "batch";
	String GROUP_API_URI_BY_ID = GROUP_API_ROOT + "/" + "{id}";
	String GET_GROUP_BY_NAME_ID = GROUP_API_ROOT + "/" + "{name}/{id}";
}
