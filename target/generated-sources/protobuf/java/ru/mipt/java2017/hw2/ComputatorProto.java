// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Computation.proto

package ru.mipt.java2017.hw2;

public final class ComputatorProto {
  private ComputatorProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_mipt_java2017_hw2_SegmentRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_mipt_java2017_hw2_SegmentRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ru_mipt_java2017_hw2_SumReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ru_mipt_java2017_hw2_SumReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021Computation.proto\022\024ru.mipt.java2017.hw" +
      "2\"-\n\016SegmentRequest\022\014\n\004left\030\001 \001(\003\022\r\n\005rig" +
      "ht\030\002 \001(\003\"\036\n\010SumReply\022\022\n\nresult_sum\030\001 \001(\003" +
      "2_\n\nComputator\022Q\n\007compute\022$.ru.mipt.java" +
      "2017.hw2.SegmentRequest\032\036.ru.mipt.java20" +
      "17.hw2.SumReply\"\000B)\n\024ru.mipt.java2017.hw" +
      "2B\017ComputatorProtoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_ru_mipt_java2017_hw2_SegmentRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ru_mipt_java2017_hw2_SegmentRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_mipt_java2017_hw2_SegmentRequest_descriptor,
        new java.lang.String[] { "Left", "Right", });
    internal_static_ru_mipt_java2017_hw2_SumReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ru_mipt_java2017_hw2_SumReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ru_mipt_java2017_hw2_SumReply_descriptor,
        new java.lang.String[] { "ResultSum", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
