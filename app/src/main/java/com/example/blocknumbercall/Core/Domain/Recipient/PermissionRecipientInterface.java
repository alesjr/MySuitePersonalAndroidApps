package com.example.blocknumbercall.Core.Domain.Recipient;

import android.content.Context;

/*@// TODO: 23/03/2022 anexar valores constantes de todas as permissoes usadas no sistema para
*      evitar de ficar puxando do manifest*/
public interface PermissionRecipientInterface {

    boolean isGranted(String permissionType);
}
