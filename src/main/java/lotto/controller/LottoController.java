package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.money.Money;
import lotto.generator.LottoGenerator;
import lotto.generator.LottoNumberGenerator;
import lotto.generator.LottoNumberGeneratorStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final LottoGenerator lottoGenerator;

    public LottoController(LottoNumberGeneratorStrategy numberGeneratorStrategy) {
        this.lottoGenerator = LottoGenerator.from(LottoNumberGenerator.from(numberGeneratorStrategy));
    }

    public void start() {
        List<Lotto> lottos = lottoGenerator.generate(Money.from(InputView.inputPurchasePrice()));

        ResultView.printPurchaseResult(lottos);

        List<LottoNumber> winningNumbers =
                InputView.inputWinningNumbers()
                        .stream()
                        .map(LottoNumber::from)
                        .collect(Collectors.toList());

        LottoNumber bonusNumber = LottoNumber.from(InputView.inputBonusNumber(winningNumbers));

        ResultView.printResult(lottos, winningNumbers, bonusNumber);
    }
}
