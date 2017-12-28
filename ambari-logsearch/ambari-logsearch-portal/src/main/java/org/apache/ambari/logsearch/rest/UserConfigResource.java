/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.ambari.logsearch.rest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.BeanParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ambari.logsearch.manager.UserConfigManager;
import org.apache.ambari.logsearch.model.common.LogFeederDataMap;
import org.apache.ambari.logsearch.model.request.impl.UserConfigRequest;
import org.apache.ambari.logsearch.model.response.UserConfigData;
import org.apache.ambari.logsearch.model.response.UserConfigDataListResponse;
import org.springframework.context.annotation.Scope;

import java.util.List;

import static org.apache.ambari.logsearch.doc.DocConstants.UserConfigOperationDescriptions.*;

@Api(value = "userconfig", description = "User config operations")
@Path("userconfig")
@Named
@Scope("request")
public class UserConfigResource {

  @Inject
  private UserConfigManager userConfigManager;

  @POST
  @Produces({"application/json"})
  @ApiOperation(SAVE_USER_CONFIG_OD)
  public String saveUserConfig(UserConfigData userConfig) {
    return userConfigManager.saveUserConfig(userConfig);
  }

  @DELETE
  @Path("/{id}")
  @ApiOperation(DELETE_USER_CONFIG_OD)
  public void deleteUserConfig(@PathParam("id") String id) {
    userConfigManager.deleteUserConfig(id);
  }

  @GET
  @Produces({"application/json"})
  @ApiOperation(GET_USER_CONFIG_OD)
  public UserConfigDataListResponse getUserConfig(@BeanParam UserConfigRequest request) {
    return userConfigManager.getUserConfig(request);
  }

  @GET
  @Path("/filters")
  @Produces({"application/json"})
  @ApiOperation(GET_USER_FILTER_OD)
  public LogFeederDataMap getUserFilter() {
    return userConfigManager.getUserFilter();
  }

  @PUT
  @Path("/filters/{id}")
  @Produces({"application/json"})
  @ApiOperation(UPDATE_USER_FILTER_OD)
  public LogFeederDataMap updateUserFilter(LogFeederDataMap request) {
    return userConfigManager.saveUserFiter(request);
  }

  @GET
  @Path("/names")
  @Produces({"application/json"})
  @ApiOperation(GET_ALL_USER_NAMES_OD)
  public List<String> getAllUserName() {
    return userConfigManager.getAllUserName();
  }

}
