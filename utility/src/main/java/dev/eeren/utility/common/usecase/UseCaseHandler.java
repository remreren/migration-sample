package dev.eeren.utility.common.usecase;

import dev.eeren.utility.common.model.UseCase;

public interface UseCaseHandler<E, T extends UseCase> {

    E handle(T useCase);

}
