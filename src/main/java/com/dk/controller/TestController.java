package com.dk.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dinesh_kumar on 12/12/15.
 */
@RestController
@RequestMapping("/service")
public class TestController extends BaseController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(
            value = "Return Json",
            notes = "json",
            response = Map.class,
            httpMethod = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful")})
    public Map<String,String> getRubric(@PathVariable("id") String id) {
        Map<String,String> ret = new HashMap<String,String>(){{put("result",id);}};
        return ret;
    }
}
