package com.brighttag.agathon.service.impl;

import com.google.inject.Inject;

import com.brighttag.agathon.model.config.CassandraConfiguration;
import com.brighttag.agathon.service.CassandraConfigurationResolver;
import com.brighttag.agathon.service.TokenService;

/**
 * Appends a {@link CassandraConfiguration#initialToken token} to the chained configuration.
 *
 * @author codyaray
 * @since 8/2/12
 */
public class TokenAppendingCassandraConfigurationResolver implements CassandraConfigurationResolver {

  private final TokenService tokenService;

  @Inject
  public TokenAppendingCassandraConfigurationResolver(TokenService tokenService) {
    this.tokenService = tokenService;
  }

  @Override
  public CassandraConfiguration getConfiguration(CassandraConfiguration chainedConfiguration) {
    return new CassandraConfiguration.Builder(chainedConfiguration)
        .initialToken(tokenService.getToken())
        .build();
  }

}
