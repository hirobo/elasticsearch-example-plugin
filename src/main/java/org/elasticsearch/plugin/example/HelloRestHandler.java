package org.elasticsearch.plugin.example;

import org.elasticsearch.rest.*;
import org.elasticsearch.common.inject.Inject;
import static org.elasticsearch.rest.RestRequest.Method.GET; 
import static org.elasticsearch.rest.RestStatus.OK;

public class HelloRestHandler implements RestHandler { 
    /*
    [examples]
    $ curl -XGET http://localhost:9200/_hello/ => Hello, world!
    $ curl -XGET http://localhost:9200/_hello?who=foo => Hello, foo!
    */

    @Inject public HelloRestHandler(RestController restController) { 
        restController.registerHandler(GET, "/_hello", this); 
    }

    @Override public void handleRequest(final RestRequest request, final RestChannel channel) { 
        String who = request.param("who"); 
        String whoSafe = (who!=null) ? who : "world"; 
        channel.sendResponse(new BytesRestResponse(OK, "Hello, " + whoSafe + "!")); 
    }

}