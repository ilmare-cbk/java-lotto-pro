package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constant.LottoConstant;

public class DefaultNumberGeneratorStrategy implements LottoNumberGeneratorStrategy {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> seedNumbers;

    public DefaultNumberGeneratorStrategy() {
        this.seedNumbers = createSeedNumbers();
    }

    private List<Integer> createSeedNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = LottoConstant.MIN_LOTTO_NUMBER; i <= LottoConstant.MAX_LOTTO_NUMBER; i++) {
            numbers.add(i);
        }

        return numbers;
    }

    @Override
    public List<LottoNumber> generate() {
        Collections.shuffle(seedNumbers);

        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            lottoNumbers.add(LottoNumber.from(seedNumbers.get(i)));
        }

        return lottoNumbers;
    }
}
