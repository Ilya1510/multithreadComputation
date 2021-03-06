// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Computation.proto

package ru.mipt.java2017.hw2;

/**
 * <pre>
 * The response message containing the greetings
 * </pre>
 *
 * Protobuf type {@code ru.mipt.java2017.hw2.SumReply}
 */
public  final class SumReply extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ru.mipt.java2017.hw2.SumReply)
    SumReplyOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SumReply.newBuilder() to construct.
  private SumReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SumReply() {
    resultSum_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SumReply(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            resultSum_ = input.readInt64();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ru.mipt.java2017.hw2.ComputatorProto.internal_static_ru_mipt_java2017_hw2_SumReply_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ru.mipt.java2017.hw2.ComputatorProto.internal_static_ru_mipt_java2017_hw2_SumReply_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ru.mipt.java2017.hw2.SumReply.class, ru.mipt.java2017.hw2.SumReply.Builder.class);
  }

  public static final int RESULT_SUM_FIELD_NUMBER = 1;
  private long resultSum_;
  /**
   * <code>int64 result_sum = 1;</code>
   */
  public long getResultSum() {
    return resultSum_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (resultSum_ != 0L) {
      output.writeInt64(1, resultSum_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (resultSum_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, resultSum_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ru.mipt.java2017.hw2.SumReply)) {
      return super.equals(obj);
    }
    ru.mipt.java2017.hw2.SumReply other = (ru.mipt.java2017.hw2.SumReply) obj;

    boolean result = true;
    result = result && (getResultSum()
        == other.getResultSum());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + RESULT_SUM_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getResultSum());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ru.mipt.java2017.hw2.SumReply parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.mipt.java2017.hw2.SumReply parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.mipt.java2017.hw2.SumReply parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.mipt.java2017.hw2.SumReply parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.mipt.java2017.hw2.SumReply parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.mipt.java2017.hw2.SumReply parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.mipt.java2017.hw2.SumReply parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ru.mipt.java2017.hw2.SumReply parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ru.mipt.java2017.hw2.SumReply parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ru.mipt.java2017.hw2.SumReply parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ru.mipt.java2017.hw2.SumReply parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ru.mipt.java2017.hw2.SumReply parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ru.mipt.java2017.hw2.SumReply prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * The response message containing the greetings
   * </pre>
   *
   * Protobuf type {@code ru.mipt.java2017.hw2.SumReply}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ru.mipt.java2017.hw2.SumReply)
      ru.mipt.java2017.hw2.SumReplyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ru.mipt.java2017.hw2.ComputatorProto.internal_static_ru_mipt_java2017_hw2_SumReply_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ru.mipt.java2017.hw2.ComputatorProto.internal_static_ru_mipt_java2017_hw2_SumReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ru.mipt.java2017.hw2.SumReply.class, ru.mipt.java2017.hw2.SumReply.Builder.class);
    }

    // Construct using ru.mipt.java2017.hw2.SumReply.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      resultSum_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ru.mipt.java2017.hw2.ComputatorProto.internal_static_ru_mipt_java2017_hw2_SumReply_descriptor;
    }

    public ru.mipt.java2017.hw2.SumReply getDefaultInstanceForType() {
      return ru.mipt.java2017.hw2.SumReply.getDefaultInstance();
    }

    public ru.mipt.java2017.hw2.SumReply build() {
      ru.mipt.java2017.hw2.SumReply result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public ru.mipt.java2017.hw2.SumReply buildPartial() {
      ru.mipt.java2017.hw2.SumReply result = new ru.mipt.java2017.hw2.SumReply(this);
      result.resultSum_ = resultSum_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ru.mipt.java2017.hw2.SumReply) {
        return mergeFrom((ru.mipt.java2017.hw2.SumReply)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ru.mipt.java2017.hw2.SumReply other) {
      if (other == ru.mipt.java2017.hw2.SumReply.getDefaultInstance()) return this;
      if (other.getResultSum() != 0L) {
        setResultSum(other.getResultSum());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ru.mipt.java2017.hw2.SumReply parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ru.mipt.java2017.hw2.SumReply) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long resultSum_ ;
    /**
     * <code>int64 result_sum = 1;</code>
     */
    public long getResultSum() {
      return resultSum_;
    }
    /**
     * <code>int64 result_sum = 1;</code>
     */
    public Builder setResultSum(long value) {
      
      resultSum_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 result_sum = 1;</code>
     */
    public Builder clearResultSum() {
      
      resultSum_ = 0L;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:ru.mipt.java2017.hw2.SumReply)
  }

  // @@protoc_insertion_point(class_scope:ru.mipt.java2017.hw2.SumReply)
  private static final ru.mipt.java2017.hw2.SumReply DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ru.mipt.java2017.hw2.SumReply();
  }

  public static ru.mipt.java2017.hw2.SumReply getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SumReply>
      PARSER = new com.google.protobuf.AbstractParser<SumReply>() {
    public SumReply parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new SumReply(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SumReply> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SumReply> getParserForType() {
    return PARSER;
  }

  public ru.mipt.java2017.hw2.SumReply getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

