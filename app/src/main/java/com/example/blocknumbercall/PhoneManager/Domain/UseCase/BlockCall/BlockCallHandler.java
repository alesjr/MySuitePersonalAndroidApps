package com.example.blocknumbercall.PhoneManager.Domain.UseCase.BlockCall;

import com.example.blocknumbercall.Core.Domain.UseCase.UseCaseHandler;
import com.example.blocknumbercall.Core.Domain.UseCase.UseCaseRequestValues;
import com.example.blocknumbercall.Core.Domain.UseCase.UseCaseResponseValues;
import com.example.blocknumbercall.PhoneManager.Domain.DTO.BlockCallDTO;
import com.example.blocknumbercall.PhoneManager.Domain.Repository.ContactRepositoryInterface;

public class BlockCallHandler implements UseCaseHandler {

    private ContactRepositoryInterface contactRepository;

    public BlockCallHandler(ContactRepositoryInterface contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public UseCaseResponseValues executeUseCase(UseCaseRequestValues requestValues) {
        if (!requestValues.validate()) {
            return new BlockCallResponseValues(
                UseCaseResponseValues.REQUEST_INVALID,
                requestValues.getErrors().toString()
            );
        };

        boolean canBlock = false;
        try {
            String phoneNumber = (String) requestValues.getJsonObject().get("phoneNumber");
            if (phoneNumber.isEmpty() || !this.contactRepository.isExists(phoneNumber)) {
                 canBlock = true;
            }
        } catch (Throwable throwable) {
            return new BlockCallResponseValues(
                UseCaseResponseValues.INTERNAL_ERROR,
                throwable.getMessage()
            );
        }
        return new BlockCallResponseValues(
            UseCaseResponseValues.SUCCESS,
            new BlockCallDTO(canBlock)
        );
    }
}
