package com.github.clovisgargione.quarkussocial.config;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.arc.lookup.LookupIfProperty;
import io.vertx.core.Vertx;
import io.vertx.ext.consul.ConsulClient;
import io.vertx.ext.consul.ConsulClientOptions;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class SocialBeanProducer {

	@ConfigProperty(name = "consul.host", defaultValue = "192.168.99.100")
	String host;
	@ConfigProperty(name = "consul.port", defaultValue = "8500")
	int port;

	@Produces
	@LookupIfProperty(name = "quarkus.stork.social-service.service-registrar.type", stringValue = "consul")
	public ConsulClient consulClient(Vertx vertx) {
		return ConsulClient.create(vertx, new ConsulClientOptions().setHost(host).setPort(port));
	}
	
}
