package es.rvillalba.spring.unittest;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;

import lombok.Data;
import uk.co.jemos.podam.api.DataProviderStrategy;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import uk.co.jemos.podam.api.RandomDataProviderStrategyImpl;

@RunWith(DataProviderRunner.class)
@Data
public abstract class SpringUnitTestParent {

    protected static PodamFactory podamFactory;

    protected static PodamFactory podamFactorySlowly;

    @BeforeClass
    public static void init() {
        initPodam();
        initPodamSlowly();
    }

    private static void initPodamSlowly() {
        DataProviderStrategy strategy = new RandomDataProviderStrategyImpl();
        strategy.setMemoization(false);
        strategy.setDefaultNumberOfCollectionElements(3);
        podamFactorySlowly = new PodamFactoryImpl(strategy);
    }

    private static void initPodam() {
        DataProviderStrategy strategy = new RandomDataProviderStrategyImpl();
        strategy.setMemoization(true);
        strategy.setDefaultNumberOfCollectionElements(3);
        podamFactory = new PodamFactoryImpl(strategy);
    }
}
