package com.pb.services;

import com.pb.entities.Sender;

/**
 * @author @bkalika
 */
public interface ISenderService {
    Sender findByInnOrCreateSender(Sender owner);
    Sender updateSender(Long id, Sender sender);
}
