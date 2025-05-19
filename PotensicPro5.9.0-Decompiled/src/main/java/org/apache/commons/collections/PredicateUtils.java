package org.apache.commons.collections;

import java.util.Collection;
import org.apache.commons.collections.functors.AllPredicate;
import org.apache.commons.collections.functors.AndPredicate;
import org.apache.commons.collections.functors.AnyPredicate;
import org.apache.commons.collections.functors.EqualPredicate;
import org.apache.commons.collections.functors.ExceptionPredicate;
import org.apache.commons.collections.functors.FalsePredicate;
import org.apache.commons.collections.functors.IdentityPredicate;
import org.apache.commons.collections.functors.InstanceofPredicate;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.functors.NonePredicate;
import org.apache.commons.collections.functors.NotNullPredicate;
import org.apache.commons.collections.functors.NotPredicate;
import org.apache.commons.collections.functors.NullIsExceptionPredicate;
import org.apache.commons.collections.functors.NullIsFalsePredicate;
import org.apache.commons.collections.functors.NullIsTruePredicate;
import org.apache.commons.collections.functors.NullPredicate;
import org.apache.commons.collections.functors.OnePredicate;
import org.apache.commons.collections.functors.OrPredicate;
import org.apache.commons.collections.functors.TransformedPredicate;
import org.apache.commons.collections.functors.TransformerPredicate;
import org.apache.commons.collections.functors.TruePredicate;
import org.apache.commons.collections.functors.UniquePredicate;

/* loaded from: classes4.dex */
public class PredicateUtils {
    public static Predicate exceptionPredicate() {
        return ExceptionPredicate.INSTANCE;
    }

    public static Predicate truePredicate() {
        return TruePredicate.INSTANCE;
    }

    public static Predicate falsePredicate() {
        return FalsePredicate.INSTANCE;
    }

    public static Predicate nullPredicate() {
        return NullPredicate.INSTANCE;
    }

    public static Predicate notNullPredicate() {
        return NotNullPredicate.INSTANCE;
    }

    public static Predicate equalPredicate(Object obj) {
        return EqualPredicate.getInstance(obj);
    }

    public static Predicate identityPredicate(Object obj) {
        return IdentityPredicate.getInstance(obj);
    }

    public static Predicate instanceofPredicate(Class cls) {
        return InstanceofPredicate.getInstance(cls);
    }

    public static Predicate uniquePredicate() {
        return UniquePredicate.getInstance();
    }

    public static Predicate invokerPredicate(String str) {
        return asPredicate(InvokerTransformer.getInstance(str));
    }

    public static Predicate invokerPredicate(String str, Class[] clsArr, Object[] objArr) {
        return asPredicate(InvokerTransformer.getInstance(str, clsArr, objArr));
    }

    public static Predicate andPredicate(Predicate predicate, Predicate predicate2) {
        return AndPredicate.getInstance(predicate, predicate2);
    }

    public static Predicate allPredicate(Predicate[] predicateArr) {
        return AllPredicate.getInstance(predicateArr);
    }

    public static Predicate allPredicate(Collection collection) {
        return AllPredicate.getInstance(collection);
    }

    public static Predicate orPredicate(Predicate predicate, Predicate predicate2) {
        return OrPredicate.getInstance(predicate, predicate2);
    }

    public static Predicate anyPredicate(Predicate[] predicateArr) {
        return AnyPredicate.getInstance(predicateArr);
    }

    public static Predicate anyPredicate(Collection collection) {
        return AnyPredicate.getInstance(collection);
    }

    public static Predicate eitherPredicate(Predicate predicate, Predicate predicate2) {
        return onePredicate(new Predicate[]{predicate, predicate2});
    }

    public static Predicate onePredicate(Predicate[] predicateArr) {
        return OnePredicate.getInstance(predicateArr);
    }

    public static Predicate onePredicate(Collection collection) {
        return OnePredicate.getInstance(collection);
    }

    public static Predicate neitherPredicate(Predicate predicate, Predicate predicate2) {
        return nonePredicate(new Predicate[]{predicate, predicate2});
    }

    public static Predicate nonePredicate(Predicate[] predicateArr) {
        return NonePredicate.getInstance(predicateArr);
    }

    public static Predicate nonePredicate(Collection collection) {
        return NonePredicate.getInstance(collection);
    }

    public static Predicate notPredicate(Predicate predicate) {
        return NotPredicate.getInstance(predicate);
    }

    public static Predicate asPredicate(Transformer transformer) {
        return TransformerPredicate.getInstance(transformer);
    }

    public static Predicate nullIsExceptionPredicate(Predicate predicate) {
        return NullIsExceptionPredicate.getInstance(predicate);
    }

    public static Predicate nullIsFalsePredicate(Predicate predicate) {
        return NullIsFalsePredicate.getInstance(predicate);
    }

    public static Predicate nullIsTruePredicate(Predicate predicate) {
        return NullIsTruePredicate.getInstance(predicate);
    }

    public static Predicate transformedPredicate(Transformer transformer, Predicate predicate) {
        return TransformedPredicate.getInstance(transformer, predicate);
    }
}
