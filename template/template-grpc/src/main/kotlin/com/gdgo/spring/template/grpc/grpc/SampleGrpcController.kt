package com.gdgo.spring.template.grpc.grpc

import com.gdgo.spring.template.RpcProto
import io.grpc.stub.StreamObserver
import org.springframework.stereotype.Component

@Component
class SampleGrpcController {
    fun listSamples(
        request: RpcProto.ListSamplesRequest,
        responseObserver: StreamObserver<RpcProto.ListSamplesResponse>
    ) {
        val response = RpcProto.ListSamplesResponse.newBuilder()
            .addSamples(RpcProto.Sample.newBuilder().setName("sample1").setDescription("sample1 desc").build())
            .addSamples(RpcProto.Sample.newBuilder().setName("sample2").build())
            .build()
        responseObserver.onNext(response)
        responseObserver.onCompleted()
    }
}
