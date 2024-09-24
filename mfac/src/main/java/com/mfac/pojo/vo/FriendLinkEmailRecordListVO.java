package com.mfac.pojo.vo;

import com.mfac.pojo.entity.FriendLinkEmailRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendLinkEmailRecordListVO extends FriendLinkEmailRecord {
    private String friendLinkName;
}
