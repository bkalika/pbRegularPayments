package com.pb.services;

import com.pb.entities.Receiver;

/**
 * @author @bkalika
 */
public interface IReceiverService {
    Receiver findByIbanOrCreateReceiver(Receiver receiver);
}
