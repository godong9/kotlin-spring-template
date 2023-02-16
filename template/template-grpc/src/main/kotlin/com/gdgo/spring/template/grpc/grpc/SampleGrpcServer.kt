package com.gdgo.spring.template.grpc.grpc

import com.gdgo.spring.template.RpcProto
import com.gdgo.spring.template.SampleServiceGrpc
import io.grpc.stub.StreamObserver
import org.lognet.springboot.grpc.GRpcService

@GRpcService
class SampleGrpcServer(
    private val sampleGrpcController: SampleGrpcController,
) : SampleServiceGrpc.SampleServiceImplBase() {
    override fun listSamples(
        request: RpcProto.ListSamplesRequest,
        responseObserver: StreamObserver<RpcProto.ListSamplesResponse>
    ) = sampleGrpcController.listSamples(request, responseObserver)
}
