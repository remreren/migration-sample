package dev.eeren.utility.common.usecase;

import dev.eeren.utility.common.model.UseCase;

public interface VoidUseCaseHandler<T extends UseCase> {

    void handle(T useCase);

}
