package org.jzen.invoicing.listeners;

import org.jzen.invoicing.service.UserService;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.boot.actuate.audit.listener.AuditApplicationEvent;

import org.springframework.context.event.EventListener;

import org.springframework.stereotype.Component;

@Component
public class AuditApplicationEventListener {

	@Autowired
	UserService userservice;

	private static final Logger logger = LoggerFactory.getLogger(AuditApplicationEventListener.class);

	@EventListener
	public void onAuditEvent(AuditApplicationEvent event) {

		AuditEvent actualAuditEvent = event.getAuditEvent();
		logger.info("On audit application event: timestamp: {}, principal: {}, type: {}, data: {}",
				actualAuditEvent.getTimestamp(), actualAuditEvent.getPrincipal(), actualAuditEvent.getType(),
				actualAuditEvent.getData());

	}

	@EventListener(condition = "#event.auditEvent.type == 'AUTHENTICATION_FAILURE'")
	public void onAuthFailure(AuditApplicationEvent event) {
		AuditEvent auditEvent = event.getAuditEvent();
		logger.info("authenticationure, user: {}", auditEvent.getPrincipal());
		logger.info("login failed event, user: {}", auditEvent.toString());
		userservice.updateLoginFailedCount(auditEvent.getPrincipal());

	}

	@EventListener(condition = "#event.auditEvent.type == 'AUTHENTICATION_SUCCESS'")
	public void onAuthSuccess(AuditApplicationEvent event) {
		AuditEvent auditEvent = event.getAuditEvent();
		logger.info("authenticationure, user: {}", auditEvent.getPrincipal());
		logger.info("login success event, user: {}", auditEvent.toString());
		userservice.resetLoginFailedCount(auditEvent.getPrincipal());

	}

}
