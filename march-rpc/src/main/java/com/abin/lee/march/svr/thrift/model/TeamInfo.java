/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.abin.lee.march.svr.thrift.model;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2017-09-07")
public class TeamInfo implements org.apache.thrift.TBase<TeamInfo, TeamInfo._Fields>, java.io.Serializable, Cloneable, Comparable<TeamInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TeamInfo");

  private static final org.apache.thrift.protocol.TField TEAM_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("teamId", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField TEAM_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("teamName", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField TEAM_PRICE_FIELD_DESC = new org.apache.thrift.protocol.TField("teamPrice", org.apache.thrift.protocol.TType.DOUBLE, (short)3);
  private static final org.apache.thrift.protocol.TField SOURCE_FIELD_DESC = new org.apache.thrift.protocol.TField("source", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField TEAM_INVENTORY_FIELD_DESC = new org.apache.thrift.protocol.TField("teamInventory", org.apache.thrift.protocol.TType.I64, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TeamInfoStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TeamInfoTupleSchemeFactory());
  }

  public long teamId; // required
  public String teamName; // required
  public double teamPrice; // required
  public String source; // required
  public long teamInventory; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TEAM_ID((short)1, "teamId"),
    TEAM_NAME((short)2, "teamName"),
    TEAM_PRICE((short)3, "teamPrice"),
    SOURCE((short)4, "source"),
    TEAM_INVENTORY((short)5, "teamInventory");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TEAM_ID
          return TEAM_ID;
        case 2: // TEAM_NAME
          return TEAM_NAME;
        case 3: // TEAM_PRICE
          return TEAM_PRICE;
        case 4: // SOURCE
          return SOURCE;
        case 5: // TEAM_INVENTORY
          return TEAM_INVENTORY;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __TEAMID_ISSET_ID = 0;
  private static final int __TEAMPRICE_ISSET_ID = 1;
  private static final int __TEAMINVENTORY_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TEAM_ID, new org.apache.thrift.meta_data.FieldMetaData("teamId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.TEAM_NAME, new org.apache.thrift.meta_data.FieldMetaData("teamName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TEAM_PRICE, new org.apache.thrift.meta_data.FieldMetaData("teamPrice", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.SOURCE, new org.apache.thrift.meta_data.FieldMetaData("source", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TEAM_INVENTORY, new org.apache.thrift.meta_data.FieldMetaData("teamInventory", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TeamInfo.class, metaDataMap);
  }

  public TeamInfo() {
  }

  public TeamInfo(
    long teamId,
    String teamName,
    double teamPrice,
    String source,
    long teamInventory)
  {
    this();
    this.teamId = teamId;
    setTeamIdIsSet(true);
    this.teamName = teamName;
    this.teamPrice = teamPrice;
    setTeamPriceIsSet(true);
    this.source = source;
    this.teamInventory = teamInventory;
    setTeamInventoryIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TeamInfo(TeamInfo other) {
    __isset_bitfield = other.__isset_bitfield;
    this.teamId = other.teamId;
    if (other.isSetTeamName()) {
      this.teamName = other.teamName;
    }
    this.teamPrice = other.teamPrice;
    if (other.isSetSource()) {
      this.source = other.source;
    }
    this.teamInventory = other.teamInventory;
  }

  public TeamInfo deepCopy() {
    return new TeamInfo(this);
  }

  @Override
  public void clear() {
    setTeamIdIsSet(false);
    this.teamId = 0;
    this.teamName = null;
    setTeamPriceIsSet(false);
    this.teamPrice = 0.0;
    this.source = null;
    setTeamInventoryIsSet(false);
    this.teamInventory = 0;
  }

  public long getTeamId() {
    return this.teamId;
  }

  public TeamInfo setTeamId(long teamId) {
    this.teamId = teamId;
    setTeamIdIsSet(true);
    return this;
  }

  public void unsetTeamId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TEAMID_ISSET_ID);
  }

  /** Returns true if field teamId is set (has been assigned a value) and false otherwise */
  public boolean isSetTeamId() {
    return EncodingUtils.testBit(__isset_bitfield, __TEAMID_ISSET_ID);
  }

  public void setTeamIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TEAMID_ISSET_ID, value);
  }

  public String getTeamName() {
    return this.teamName;
  }

  public TeamInfo setTeamName(String teamName) {
    this.teamName = teamName;
    return this;
  }

  public void unsetTeamName() {
    this.teamName = null;
  }

  /** Returns true if field teamName is set (has been assigned a value) and false otherwise */
  public boolean isSetTeamName() {
    return this.teamName != null;
  }

  public void setTeamNameIsSet(boolean value) {
    if (!value) {
      this.teamName = null;
    }
  }

  public double getTeamPrice() {
    return this.teamPrice;
  }

  public TeamInfo setTeamPrice(double teamPrice) {
    this.teamPrice = teamPrice;
    setTeamPriceIsSet(true);
    return this;
  }

  public void unsetTeamPrice() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TEAMPRICE_ISSET_ID);
  }

  /** Returns true if field teamPrice is set (has been assigned a value) and false otherwise */
  public boolean isSetTeamPrice() {
    return EncodingUtils.testBit(__isset_bitfield, __TEAMPRICE_ISSET_ID);
  }

  public void setTeamPriceIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TEAMPRICE_ISSET_ID, value);
  }

  public String getSource() {
    return this.source;
  }

  public TeamInfo setSource(String source) {
    this.source = source;
    return this;
  }

  public void unsetSource() {
    this.source = null;
  }

  /** Returns true if field source is set (has been assigned a value) and false otherwise */
  public boolean isSetSource() {
    return this.source != null;
  }

  public void setSourceIsSet(boolean value) {
    if (!value) {
      this.source = null;
    }
  }

  public long getTeamInventory() {
    return this.teamInventory;
  }

  public TeamInfo setTeamInventory(long teamInventory) {
    this.teamInventory = teamInventory;
    setTeamInventoryIsSet(true);
    return this;
  }

  public void unsetTeamInventory() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TEAMINVENTORY_ISSET_ID);
  }

  /** Returns true if field teamInventory is set (has been assigned a value) and false otherwise */
  public boolean isSetTeamInventory() {
    return EncodingUtils.testBit(__isset_bitfield, __TEAMINVENTORY_ISSET_ID);
  }

  public void setTeamInventoryIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TEAMINVENTORY_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TEAM_ID:
      if (value == null) {
        unsetTeamId();
      } else {
        setTeamId((Long)value);
      }
      break;

    case TEAM_NAME:
      if (value == null) {
        unsetTeamName();
      } else {
        setTeamName((String)value);
      }
      break;

    case TEAM_PRICE:
      if (value == null) {
        unsetTeamPrice();
      } else {
        setTeamPrice((Double)value);
      }
      break;

    case SOURCE:
      if (value == null) {
        unsetSource();
      } else {
        setSource((String)value);
      }
      break;

    case TEAM_INVENTORY:
      if (value == null) {
        unsetTeamInventory();
      } else {
        setTeamInventory((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TEAM_ID:
      return getTeamId();

    case TEAM_NAME:
      return getTeamName();

    case TEAM_PRICE:
      return getTeamPrice();

    case SOURCE:
      return getSource();

    case TEAM_INVENTORY:
      return getTeamInventory();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TEAM_ID:
      return isSetTeamId();
    case TEAM_NAME:
      return isSetTeamName();
    case TEAM_PRICE:
      return isSetTeamPrice();
    case SOURCE:
      return isSetSource();
    case TEAM_INVENTORY:
      return isSetTeamInventory();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TeamInfo)
      return this.equals((TeamInfo)that);
    return false;
  }

  public boolean equals(TeamInfo that) {
    if (that == null)
      return false;

    boolean this_present_teamId = true;
    boolean that_present_teamId = true;
    if (this_present_teamId || that_present_teamId) {
      if (!(this_present_teamId && that_present_teamId))
        return false;
      if (this.teamId != that.teamId)
        return false;
    }

    boolean this_present_teamName = true && this.isSetTeamName();
    boolean that_present_teamName = true && that.isSetTeamName();
    if (this_present_teamName || that_present_teamName) {
      if (!(this_present_teamName && that_present_teamName))
        return false;
      if (!this.teamName.equals(that.teamName))
        return false;
    }

    boolean this_present_teamPrice = true;
    boolean that_present_teamPrice = true;
    if (this_present_teamPrice || that_present_teamPrice) {
      if (!(this_present_teamPrice && that_present_teamPrice))
        return false;
      if (this.teamPrice != that.teamPrice)
        return false;
    }

    boolean this_present_source = true && this.isSetSource();
    boolean that_present_source = true && that.isSetSource();
    if (this_present_source || that_present_source) {
      if (!(this_present_source && that_present_source))
        return false;
      if (!this.source.equals(that.source))
        return false;
    }

    boolean this_present_teamInventory = true;
    boolean that_present_teamInventory = true;
    if (this_present_teamInventory || that_present_teamInventory) {
      if (!(this_present_teamInventory && that_present_teamInventory))
        return false;
      if (this.teamInventory != that.teamInventory)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_teamId = true;
    list.add(present_teamId);
    if (present_teamId)
      list.add(teamId);

    boolean present_teamName = true && (isSetTeamName());
    list.add(present_teamName);
    if (present_teamName)
      list.add(teamName);

    boolean present_teamPrice = true;
    list.add(present_teamPrice);
    if (present_teamPrice)
      list.add(teamPrice);

    boolean present_source = true && (isSetSource());
    list.add(present_source);
    if (present_source)
      list.add(source);

    boolean present_teamInventory = true;
    list.add(present_teamInventory);
    if (present_teamInventory)
      list.add(teamInventory);

    return list.hashCode();
  }

  @Override
  public int compareTo(TeamInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetTeamId()).compareTo(other.isSetTeamId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTeamId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.teamId, other.teamId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTeamName()).compareTo(other.isSetTeamName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTeamName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.teamName, other.teamName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTeamPrice()).compareTo(other.isSetTeamPrice());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTeamPrice()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.teamPrice, other.teamPrice);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSource()).compareTo(other.isSetSource());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSource()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.source, other.source);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTeamInventory()).compareTo(other.isSetTeamInventory());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTeamInventory()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.teamInventory, other.teamInventory);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TeamInfo(");
    boolean first = true;

    sb.append("teamId:");
    sb.append(this.teamId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("teamName:");
    if (this.teamName == null) {
      sb.append("null");
    } else {
      sb.append(this.teamName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("teamPrice:");
    sb.append(this.teamPrice);
    first = false;
    if (!first) sb.append(", ");
    sb.append("source:");
    if (this.source == null) {
      sb.append("null");
    } else {
      sb.append(this.source);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("teamInventory:");
    sb.append(this.teamInventory);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TeamInfoStandardSchemeFactory implements SchemeFactory {
    public TeamInfoStandardScheme getScheme() {
      return new TeamInfoStandardScheme();
    }
  }

  private static class TeamInfoStandardScheme extends StandardScheme<TeamInfo> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TeamInfo struct) throws TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TEAM_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.teamId = iprot.readI64();
              struct.setTeamIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TEAM_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.teamName = iprot.readString();
              struct.setTeamNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TEAM_PRICE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.teamPrice = iprot.readDouble();
              struct.setTeamPriceIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // SOURCE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.source = iprot.readString();
              struct.setSourceIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // TEAM_INVENTORY
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.teamInventory = iprot.readI64();
              struct.setTeamInventoryIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TeamInfo struct) throws TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(TEAM_ID_FIELD_DESC);
      oprot.writeI64(struct.teamId);
      oprot.writeFieldEnd();
      if (struct.teamName != null) {
        oprot.writeFieldBegin(TEAM_NAME_FIELD_DESC);
        oprot.writeString(struct.teamName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(TEAM_PRICE_FIELD_DESC);
      oprot.writeDouble(struct.teamPrice);
      oprot.writeFieldEnd();
      if (struct.source != null) {
        oprot.writeFieldBegin(SOURCE_FIELD_DESC);
        oprot.writeString(struct.source);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(TEAM_INVENTORY_FIELD_DESC);
      oprot.writeI64(struct.teamInventory);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TeamInfoTupleSchemeFactory implements SchemeFactory {
    public TeamInfoTupleScheme getScheme() {
      return new TeamInfoTupleScheme();
    }
  }

  private static class TeamInfoTupleScheme extends TupleScheme<TeamInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TeamInfo struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetTeamId()) {
        optionals.set(0);
      }
      if (struct.isSetTeamName()) {
        optionals.set(1);
      }
      if (struct.isSetTeamPrice()) {
        optionals.set(2);
      }
      if (struct.isSetSource()) {
        optionals.set(3);
      }
      if (struct.isSetTeamInventory()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetTeamId()) {
        oprot.writeI64(struct.teamId);
      }
      if (struct.isSetTeamName()) {
        oprot.writeString(struct.teamName);
      }
      if (struct.isSetTeamPrice()) {
        oprot.writeDouble(struct.teamPrice);
      }
      if (struct.isSetSource()) {
        oprot.writeString(struct.source);
      }
      if (struct.isSetTeamInventory()) {
        oprot.writeI64(struct.teamInventory);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TeamInfo struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.teamId = iprot.readI64();
        struct.setTeamIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.teamName = iprot.readString();
        struct.setTeamNameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.teamPrice = iprot.readDouble();
        struct.setTeamPriceIsSet(true);
      }
      if (incoming.get(3)) {
        struct.source = iprot.readString();
        struct.setSourceIsSet(true);
      }
      if (incoming.get(4)) {
        struct.teamInventory = iprot.readI64();
        struct.setTeamInventoryIsSet(true);
      }
    }
  }

}

