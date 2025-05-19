package org.dom4j.rule;

import java.util.HashMap;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

/* loaded from: classes5.dex */
public class Mode {
    private Map attributeNameRuleSets;
    private Map elementNameRuleSets;
    private RuleSet[] ruleSets = new RuleSet[14];

    public void fireRule(Node node) throws Exception {
        Rule matchingRule;
        Action action;
        if (node == null || (matchingRule = getMatchingRule(node)) == null || (action = matchingRule.getAction()) == null) {
            return;
        }
        action.run(node);
    }

    public void applyTemplates(Element element) throws Exception {
        int attributeCount = element.attributeCount();
        for (int i = 0; i < attributeCount; i++) {
            fireRule(element.attribute(i));
        }
        int nodeCount = element.nodeCount();
        for (int i2 = 0; i2 < nodeCount; i2++) {
            fireRule(element.node(i2));
        }
    }

    public void applyTemplates(Document document) throws Exception {
        int nodeCount = document.nodeCount();
        for (int i = 0; i < nodeCount; i++) {
            fireRule(document.node(i));
        }
    }

    public void addRule(Rule rule) {
        short matchType = rule.getMatchType();
        String matchesNodeName = rule.getMatchesNodeName();
        if (matchesNodeName != null) {
            if (matchType == 1) {
                this.elementNameRuleSets = addToNameMap(this.elementNameRuleSets, matchesNodeName, rule);
            } else if (matchType == 2) {
                this.attributeNameRuleSets = addToNameMap(this.attributeNameRuleSets, matchesNodeName, rule);
            }
        }
        if (matchType >= 14) {
            matchType = 0;
        }
        if (matchType == 0) {
            int length = this.ruleSets.length;
            for (int i = 1; i < length; i++) {
                RuleSet ruleSet = this.ruleSets[i];
                if (ruleSet != null) {
                    ruleSet.addRule(rule);
                }
            }
        }
        getRuleSet(matchType).addRule(rule);
    }

    public void removeRule(Rule rule) {
        short matchType = rule.getMatchType();
        String matchesNodeName = rule.getMatchesNodeName();
        if (matchesNodeName != null) {
            if (matchType == 1) {
                removeFromNameMap(this.elementNameRuleSets, matchesNodeName, rule);
            } else if (matchType == 2) {
                removeFromNameMap(this.attributeNameRuleSets, matchesNodeName, rule);
            }
        }
        if (matchType >= 14) {
            matchType = 0;
        }
        getRuleSet(matchType).removeRule(rule);
        if (matchType != 0) {
            getRuleSet(0).removeRule(rule);
        }
    }

    public Rule getMatchingRule(Node node) {
        Rule matchingRule;
        RuleSet ruleSet;
        Rule matchingRule2;
        short nodeType = node.getNodeType();
        if (nodeType == 1) {
            if (this.elementNameRuleSets != null) {
                RuleSet ruleSet2 = (RuleSet) this.elementNameRuleSets.get(node.getName());
                if (ruleSet2 != null && (matchingRule2 = ruleSet2.getMatchingRule(node)) != null) {
                    return matchingRule2;
                }
            }
        } else if (nodeType == 2 && this.attributeNameRuleSets != null) {
            RuleSet ruleSet3 = (RuleSet) this.attributeNameRuleSets.get(node.getName());
            if (ruleSet3 != null && (matchingRule = ruleSet3.getMatchingRule(node)) != null) {
                return matchingRule;
            }
        }
        if (nodeType < 0 || nodeType >= this.ruleSets.length) {
            nodeType = 0;
        }
        RuleSet ruleSet4 = this.ruleSets[nodeType];
        Rule matchingRule3 = ruleSet4 != null ? ruleSet4.getMatchingRule(node) : null;
        return (matchingRule3 != null || nodeType == 0 || (ruleSet = this.ruleSets[0]) == null) ? matchingRule3 : ruleSet.getMatchingRule(node);
    }

    protected RuleSet getRuleSet(int i) {
        RuleSet ruleSet;
        RuleSet ruleSet2 = this.ruleSets[i];
        if (ruleSet2 == null) {
            ruleSet2 = new RuleSet();
            RuleSet[] ruleSetArr = this.ruleSets;
            ruleSetArr[i] = ruleSet2;
            if (i != 0 && (ruleSet = ruleSetArr[0]) != null) {
                ruleSet2.addAll(ruleSet);
            }
        }
        return ruleSet2;
    }

    protected Map addToNameMap(Map map, String str, Rule rule) {
        if (map == null) {
            map = new HashMap();
        }
        RuleSet ruleSet = (RuleSet) map.get(str);
        if (ruleSet == null) {
            ruleSet = new RuleSet();
            map.put(str, ruleSet);
        }
        ruleSet.addRule(rule);
        return map;
    }

    protected void removeFromNameMap(Map map, String str, Rule rule) {
        RuleSet ruleSet;
        if (map == null || (ruleSet = (RuleSet) map.get(str)) == null) {
            return;
        }
        ruleSet.removeRule(rule);
    }
}
