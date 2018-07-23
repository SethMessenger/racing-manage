namespace java com.wxmp.thrift

include "params.thrift"
 
struct Parameter{
	1: required i32 id;
	2: required string name;
}

struct Parameter{
	1: required i32 id;
	2: required string name;
}

struct ParameterReq{
	1: required i32 id;
	2: required string name;
}

struct ResultBool{
	1: ThriftResult result;
	2: bool value;
}

struct ResultDouble{
	1: ThriftResult result;
	2: double value;
}

struct ResultListStr{
	1: ThriftResult result;
	2: list<string> value;
}

struct ResultMapStrStr{
	1: ThriftResult result;
	2: map<i32,string> value;
}

enum ThriftResult {
	SUCCESS = 0,
	SERVER_UNWORKING = 1,
	NO_CONTENT = 2,
	PARAMETER_ERROR = 3,
	EXCEPTION = 4,
	INDEX_ERROR = 5,
	UNKNOWN_ERROR = 6,
	DATA_NOT_COMPLETE = 7,
	INNER_ERROR = 8
}
 
service DemoService{
	ResultListStr demoMethod(1:string param1, 2:Parameter param2, 3:map<string,string> param3);
}