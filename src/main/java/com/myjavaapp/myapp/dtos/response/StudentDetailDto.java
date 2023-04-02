package com.myjavaapp.myapp.dtos.response;

import java.util.UUID;

public class StudentDetailDto {
    private UUID detailId;
    private String detailText;

    public StudentDetailDto(UUID detailId, String detailText) {
        this.detailId = detailId;
        this.detailText = detailText;
    }

    public UUID getDetailId() {
        return detailId;
    }

    public void setDetailId(UUID detailId) {
        this.detailId = detailId;
    }

    public String getDetailText() {
        return detailText;
    }

    public void setDetailText(String detailText) {
        this.detailText = detailText;
    }
}
