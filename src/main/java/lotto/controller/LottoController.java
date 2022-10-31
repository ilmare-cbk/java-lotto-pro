package lotto.controller;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;
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
        Money purchasePrice = Money.from(InputView.inputPurchasePrice());

        List<Lotto> lottos = lottoGenerator.generate(purchasePrice);
        ResultView.printPurchaseResult(lottos);

        WinningLotto winningLotto = InputView.inputWinningLottos();
        ResultView.printResult(lottos, winningLotto);
    }
}
