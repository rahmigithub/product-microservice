package org.alkan.stockmanager.productservice.exception.exceptions;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.alkan.stockmanager.productservice.enums.Language;
import org.alkan.stockmanager.productservice.exception.enums.FriendlyMessageCodes;
import org.alkan.stockmanager.productservice.exception.enums.IFriendlyMessageCode;
import org.alkan.stockmanager.productservice.exception.utils.FriendlyMessageUtils;

@Slf4j
@Getter
public class ProductNotCreatedException extends RuntimeException {

    private final Language language;

    private final IFriendlyMessageCode friendlyMessageCode;

    public ProductNotCreatedException(Language language, IFriendlyMessageCode friendlyMessageCode, String message) {
        super(FriendlyMessageUtils.getFriendlyMessage(language,friendlyMessageCode));
        this.language = language;
        this.friendlyMessageCode = friendlyMessageCode;
        log.error("[ProductNotCreatedException] -> message: {} developer message: {}", FriendlyMessageUtils.getFriendlyMessage(language,friendlyMessageCode), message);
    }
}
