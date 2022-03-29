package com.example.blocknumbercall.PhoneManager.Application.Service;

import android.util.Log;

import com.example.blocknumbercall.Core.Domain.UseCase.UseCaseHandler;
import com.example.blocknumbercall.Core.Domain.UseCase.UseCaseRequestValues;
import com.example.blocknumbercall.Core.Domain.UseCase.UseCaseResponseValues;
import com.example.blocknumbercall.PhoneManager.Domain.DTO.BlockCallDTO;
import com.example.blocknumbercall.PhoneManager.Domain.Recipient.TelecomManagerRecipientInterface;
import com.example.blocknumbercall.PhoneManager.Domain.Repository.ContactRepositoryInterface;
import com.example.blocknumbercall.PhoneManager.Domain.Service.BlockCallServiceInterface;
import com.example.blocknumbercall.PhoneManager.Domain.UseCase.BlockCall.BlockCallHandler;
import com.example.blocknumbercall.PhoneManager.Domain.UseCase.BlockCall.BlockCallRequestValues;

import org.json.JSONObject;

public class BlockCallService implements BlockCallServiceInterface {

    private ContactRepositoryInterface contactRepository;
    private TelecomManagerRecipientInterface telecomManagerRecipient;

    public BlockCallService(
        ContactRepositoryInterface contactRepository,
        TelecomManagerRecipientInterface telecomManagerRecipient
    ) {
        this.contactRepository = contactRepository;
        this.telecomManagerRecipient = telecomManagerRecipient;
    }

    @Override
    public void blockCall(String phoneNumber) {

        UseCaseRequestValues useCaseRequestValues = new BlockCallRequestValues();
        JSONObject jsonObject = useCaseRequestValues.getJsonObject();
        try {
            jsonObject.put("phoneNumber", phoneNumber);
            UseCaseHandler useCaseHandler = new BlockCallHandler(this.contactRepository);
            UseCaseResponseValues responseValues = useCaseHandler.executeUseCase(useCaseRequestValues);
            BlockCallDTO blockCallDTO = (BlockCallDTO) responseValues.getPayload().get("data");
            if (blockCallDTO.isCanBlock()) {
                this.telecomManagerRecipient.endCall();
                /**
                 * todo: adicionar logs de chamadas encerradas aqui e também fazer o upload na conta da google no drive
                 * uma lista desses números (a lista é formato json)
                 */
            }
        } catch (Throwable throwable) {
            Log.e("BlockCall", throwable.getMessage(), throwable);
            throwable.printStackTrace();
        }
    }
}
