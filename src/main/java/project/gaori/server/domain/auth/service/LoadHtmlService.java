package project.gaori.server.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Service
@RequiredArgsConstructor
public class LoadHtmlService {
    private final SpringTemplateEngine springTemplateEngine;

    public String execute(String code) {

        Context context = new Context();
        context.setVariable("code", code);

        return springTemplateEngine.process("email", context);
    }
}
