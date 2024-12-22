package com.demo.brandbacks.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.brandbacks.model.QrCode;
import com.demo.brandbacks.repository.QrcodeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class QrCodeService {

	@Autowired
	QrcodeRepository qrCodeRepo;
	
	public void saveQrcode() {
		QrCode qrcode = new QrCode();
		qrcode.setProductId("1");
		qrcode.setQrCodeId("21321313");
		qrcode.setStatus(1);
		qrCodeRepo.save(qrcode);
	}

	public QrCode getQrCode(String qrCodeId) {
		try {
			Optional<QrCode> qrCode = qrCodeRepo.findByQrCodeId(qrCodeId);
			log.info("{}", qrCode.get());
			return qrCode.isPresent() ? qrCode.get(): null;
		}catch(Exception exp) {
			exp.printStackTrace();
		}
		return null;
	}
}
