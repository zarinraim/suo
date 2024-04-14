package com.zarinraim.accounting.utils

interface UseCase<in Input, out Output> {

    operator fun invoke(input: Input): Output
}

interface UnitUseCase<out Output> {

    operator fun invoke(): Output
}

interface SuspendUseCase<in Input, out Output> {

    suspend operator fun invoke(input: Input): Output
}

interface SuspendUnitUseCase<out Output> {

    suspend operator fun invoke(): Output
}