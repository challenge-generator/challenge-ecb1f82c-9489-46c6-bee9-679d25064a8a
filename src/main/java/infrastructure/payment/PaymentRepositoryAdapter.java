package infrastructure.payment;

import domain.Payment;
import domain.PaymentRepository;
import java.util.Optional;
import java.util.UUID;

public class PaymentRepositoryAdapter implements PaymentRepository {

    @Override
    public Payment save(Payment payment) {
        // TODO(reto): Implementar la persistencia del pago en la base de datos.
        // El método debe guardar el Payment y retornarlo con su estado actualizado.
        // Considerar el manejo de errores de base de datos.
        throw new UnsupportedOperationException("TODO(reto): Implementar persistencia del pago");
    }

    @Override
    public Optional<Payment> findById(UUID id) {
        // TODO(reto): Implementar la búsqueda de un pago por su ID.
        // Retorna un Optional con el pago si existe, o vacío si no se encuentra.
        throw new UnsupportedOperationException("TODO(reto): Implementar búsqueda por ID");
    }

    @Override
    public boolean existsById(UUID id) {
        // TODO(reto): Verificar si existe un pago con el ID proporcionado.
        // Retorna true si existe, false en caso contrario.
        throw new UnsupportedOperationException("TODO(reto): Implementar verificación de existencia");
    }
}