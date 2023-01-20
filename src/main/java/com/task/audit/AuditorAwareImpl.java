package com.task.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import com.task.config.Constants;
import com.task.security.SecurityUtils;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
        return Optional.of(SecurityUtils.getCurrentUserUsername().orElse(Constants.SYSTEM_ACCOUNT));
	}

}
