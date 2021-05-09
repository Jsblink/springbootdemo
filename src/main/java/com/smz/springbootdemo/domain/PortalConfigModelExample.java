package com.smz.springbootdemo.domain;

import java.util.ArrayList;
import java.util.List;

public class PortalConfigModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PortalConfigModelExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andParamnameIsNull() {
            addCriterion("paramname is null");
            return (Criteria) this;
        }

        public Criteria andParamnameIsNotNull() {
            addCriterion("paramname is not null");
            return (Criteria) this;
        }

        public Criteria andParamnameEqualTo(String value) {
            addCriterion("paramname =", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameNotEqualTo(String value) {
            addCriterion("paramname <>", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameGreaterThan(String value) {
            addCriterion("paramname >", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameGreaterThanOrEqualTo(String value) {
            addCriterion("paramname >=", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameLessThan(String value) {
            addCriterion("paramname <", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameLessThanOrEqualTo(String value) {
            addCriterion("paramname <=", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameLike(String value) {
            addCriterion("paramname like", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameNotLike(String value) {
            addCriterion("paramname not like", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameIn(List<String> values) {
            addCriterion("paramname in", values, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameNotIn(List<String> values) {
            addCriterion("paramname not in", values, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameBetween(String value1, String value2) {
            addCriterion("paramname between", value1, value2, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameNotBetween(String value1, String value2) {
            addCriterion("paramname not between", value1, value2, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamkeyIsNull() {
            addCriterion("paramkey is null");
            return (Criteria) this;
        }

        public Criteria andParamkeyIsNotNull() {
            addCriterion("paramkey is not null");
            return (Criteria) this;
        }

        public Criteria andParamkeyEqualTo(String value) {
            addCriterion("paramkey =", value, "paramkey");
            return (Criteria) this;
        }

        public Criteria andParamkeyNotEqualTo(String value) {
            addCriterion("paramkey <>", value, "paramkey");
            return (Criteria) this;
        }

        public Criteria andParamkeyGreaterThan(String value) {
            addCriterion("paramkey >", value, "paramkey");
            return (Criteria) this;
        }

        public Criteria andParamkeyGreaterThanOrEqualTo(String value) {
            addCriterion("paramkey >=", value, "paramkey");
            return (Criteria) this;
        }

        public Criteria andParamkeyLessThan(String value) {
            addCriterion("paramkey <", value, "paramkey");
            return (Criteria) this;
        }

        public Criteria andParamkeyLessThanOrEqualTo(String value) {
            addCriterion("paramkey <=", value, "paramkey");
            return (Criteria) this;
        }

        public Criteria andParamkeyLike(String value) {
            addCriterion("paramkey like", value, "paramkey");
            return (Criteria) this;
        }

        public Criteria andParamkeyNotLike(String value) {
            addCriterion("paramkey not like", value, "paramkey");
            return (Criteria) this;
        }

        public Criteria andParamkeyIn(List<String> values) {
            addCriterion("paramkey in", values, "paramkey");
            return (Criteria) this;
        }

        public Criteria andParamkeyNotIn(List<String> values) {
            addCriterion("paramkey not in", values, "paramkey");
            return (Criteria) this;
        }

        public Criteria andParamkeyBetween(String value1, String value2) {
            addCriterion("paramkey between", value1, value2, "paramkey");
            return (Criteria) this;
        }

        public Criteria andParamkeyNotBetween(String value1, String value2) {
            addCriterion("paramkey not between", value1, value2, "paramkey");
            return (Criteria) this;
        }

        public Criteria andParamvalueIsNull() {
            addCriterion("paramvalue is null");
            return (Criteria) this;
        }

        public Criteria andParamvalueIsNotNull() {
            addCriterion("paramvalue is not null");
            return (Criteria) this;
        }

        public Criteria andParamvalueEqualTo(String value) {
            addCriterion("paramvalue =", value, "paramvalue");
            return (Criteria) this;
        }

        public Criteria andParamvalueNotEqualTo(String value) {
            addCriterion("paramvalue <>", value, "paramvalue");
            return (Criteria) this;
        }

        public Criteria andParamvalueGreaterThan(String value) {
            addCriterion("paramvalue >", value, "paramvalue");
            return (Criteria) this;
        }

        public Criteria andParamvalueGreaterThanOrEqualTo(String value) {
            addCriterion("paramvalue >=", value, "paramvalue");
            return (Criteria) this;
        }

        public Criteria andParamvalueLessThan(String value) {
            addCriterion("paramvalue <", value, "paramvalue");
            return (Criteria) this;
        }

        public Criteria andParamvalueLessThanOrEqualTo(String value) {
            addCriterion("paramvalue <=", value, "paramvalue");
            return (Criteria) this;
        }

        public Criteria andParamvalueLike(String value) {
            addCriterion("paramvalue like", value, "paramvalue");
            return (Criteria) this;
        }

        public Criteria andParamvalueNotLike(String value) {
            addCriterion("paramvalue not like", value, "paramvalue");
            return (Criteria) this;
        }

        public Criteria andParamvalueIn(List<String> values) {
            addCriterion("paramvalue in", values, "paramvalue");
            return (Criteria) this;
        }

        public Criteria andParamvalueNotIn(List<String> values) {
            addCriterion("paramvalue not in", values, "paramvalue");
            return (Criteria) this;
        }

        public Criteria andParamvalueBetween(String value1, String value2) {
            addCriterion("paramvalue between", value1, value2, "paramvalue");
            return (Criteria) this;
        }

        public Criteria andParamvalueNotBetween(String value1, String value2) {
            addCriterion("paramvalue not between", value1, value2, "paramvalue");
            return (Criteria) this;
        }

        public Criteria andParamdescIsNull() {
            addCriterion("paramdesc is null");
            return (Criteria) this;
        }

        public Criteria andParamdescIsNotNull() {
            addCriterion("paramdesc is not null");
            return (Criteria) this;
        }

        public Criteria andParamdescEqualTo(String value) {
            addCriterion("paramdesc =", value, "paramdesc");
            return (Criteria) this;
        }

        public Criteria andParamdescNotEqualTo(String value) {
            addCriterion("paramdesc <>", value, "paramdesc");
            return (Criteria) this;
        }

        public Criteria andParamdescGreaterThan(String value) {
            addCriterion("paramdesc >", value, "paramdesc");
            return (Criteria) this;
        }

        public Criteria andParamdescGreaterThanOrEqualTo(String value) {
            addCriterion("paramdesc >=", value, "paramdesc");
            return (Criteria) this;
        }

        public Criteria andParamdescLessThan(String value) {
            addCriterion("paramdesc <", value, "paramdesc");
            return (Criteria) this;
        }

        public Criteria andParamdescLessThanOrEqualTo(String value) {
            addCriterion("paramdesc <=", value, "paramdesc");
            return (Criteria) this;
        }

        public Criteria andParamdescLike(String value) {
            addCriterion("paramdesc like", value, "paramdesc");
            return (Criteria) this;
        }

        public Criteria andParamdescNotLike(String value) {
            addCriterion("paramdesc not like", value, "paramdesc");
            return (Criteria) this;
        }

        public Criteria andParamdescIn(List<String> values) {
            addCriterion("paramdesc in", values, "paramdesc");
            return (Criteria) this;
        }

        public Criteria andParamdescNotIn(List<String> values) {
            addCriterion("paramdesc not in", values, "paramdesc");
            return (Criteria) this;
        }

        public Criteria andParamdescBetween(String value1, String value2) {
            addCriterion("paramdesc between", value1, value2, "paramdesc");
            return (Criteria) this;
        }

        public Criteria andParamdescNotBetween(String value1, String value2) {
            addCriterion("paramdesc not between", value1, value2, "paramdesc");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}