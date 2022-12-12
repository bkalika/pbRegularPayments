package com.pb.dto;

/**
 * @author @bkalika
 */
public class ReceiverDto {
    private Long id;
    private String iban;
    private Long mfo;
    private Long okpo;
    private String name;
    public ReceiverDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Long getMfo() {
        return mfo;
    }

    public void setMfo(Long mfo) {
        this.mfo = mfo;
    }

    public Long getOkpo() {
        return okpo;
    }

    public void setOkpo(Long okpo) {
        this.okpo = okpo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
