package com.example.blocknumbercall.PhoneManager.Domain.DTO;

public class BlockCallDTO {

    private boolean canBlock;

    public BlockCallDTO(boolean canBlock) {
        this.canBlock = canBlock;
    }

    public boolean isCanBlock() {
        return canBlock;
    }
}
