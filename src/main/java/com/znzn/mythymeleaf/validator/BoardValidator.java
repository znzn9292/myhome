package com.znzn.mythymeleaf.validator;


import com.znzn.mythymeleaf.model.Board;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;

@Component
public class BoardValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Board.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Board board = (Board) obj;
        if(StringUtils.isEmpty(board.getContent())){
            errors.rejectValue("content", "key", "내용을 입력 하세요.");
        }
    }
}
