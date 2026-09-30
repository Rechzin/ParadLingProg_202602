package br.edu.atitus.currencyapi.services;

import br.edu.atitus.currencyapi.dtos.CurrencyResponse;
import br.edu.atitus.currencyapi.entities.CurrencyEntity;
import br.edu.atitus.currencyapi.repositories.CurrencyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceJpa implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyServiceJpa(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public CurrencyResponse findBySourceCurrencyAndTargetCurrency(
            String sourceCurrency,
            String targetCurrency) throws Exception {

        CurrencyEntity currency = currencyRepository
                .findBySourceCurrencyAndTargetCurrency(
                        sourceCurrency.toUpperCase(),
                        targetCurrency.toUpperCase()
                )
                .orElseThrow(() -> new EntityNotFoundException("Currency not found"));

        return new CurrencyResponse(
                currency.getSourceCurrency(),
                currency.getTargetCurrency(),
                currency.getConversionRate(),
                "Currency API running in Port: 8100"
        );
    }
}