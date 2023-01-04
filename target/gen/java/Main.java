/**
 * GENERATED CODE - DO NOT CHANGE
 */

import astra.core.*;
import astra.execution.*;
import astra.event.*;
import astra.messaging.*;
import astra.formula.*;
import astra.lang.*;
import astra.statement.*;
import astra.term.*;
import astra.type.*;
import astra.tr.*;
import astra.reasoner.util.*;


public class Main extends ASTRAClass {
	public Main() {
		setParents(new Class[] {astra.lang.Agent.class});
		addInference(new Inference(
			new Predicate("free", new Term[] {
				new Variable(Type.STRING, "X",false)
			}),
			new NOT(
				new ModuleFormula("ei",
					new Predicate("on", new Term[] {
						new Variable(Type.STRING, "Y",false),
						new Variable(Type.STRING, "X")
					}),
					new ModuleFormulaAdaptor() {
						public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
							return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
						}
					}
				)
			)
		));
		addInference(new Inference(
			new Predicate("free", new Term[] {
				new Variable(Type.STRING, "X",false)
			}),
			new Comparison("==",
				new Variable(Type.STRING, "X"),
				Primitive.newPrimitive("table")
			)
		));
		addInference(new Inference(
			new Predicate("tower", new Term[] {
				new Variable(Type.LIST, "blocks",false)
			}),
			new AND(
				new ModuleFormula("ei",
					new Predicate("on", new Term[] {
						new AtIndex(
							new Variable(Type.LIST, "blocks"),
							Primitive.newPrimitive(0),
							Type.STRING
						),
						new AtIndex(
							new Variable(Type.LIST, "blocks"),
							Primitive.newPrimitive(1),
							Type.STRING
						)
					}),
					new ModuleFormulaAdaptor() {
						public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
							return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
						}
					}
				),
				new Predicate("free", new Term[] {
					new AtIndex(
						new Variable(Type.LIST, "blocks"),
						Primitive.newPrimitive(0),
						Type.STRING
					)
				})
			)
		));
		addRule(new Rule(
			"Main", new int[] {23,9,23,30},
			new GoalEvent('+',
				new Goal(
					new Predicate("tower", new Term[] {
						new Variable(Type.LIST, "blocks",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {23,29,38,5},
				new Statement[] {
					new Declaration(
						new Variable(Type.STRING, "X"),
						"Main", new int[] {25,8,38,5},
						Primitive.newPrimitive("table")
					),
					new Declaration(
						new Variable(Type.INTEGER, "i"),
						"Main", new int[] {26,8,38,5},
						Operator.newOperator('-',
							new Count(
								new Variable(Type.LIST, "blocks")
							),
							Primitive.newPrimitive(1)
						)
					),
					new While(
						"Main", new int[] {27,8,38,5},
						new Comparison(">=",
							new Variable(Type.INTEGER, "i"),
							Primitive.newPrimitive(0)
						),
						new Block(
							"Main", new int[] {27,22,36,9},
							new Statement[] {
								new Declaration(
									new Variable(Type.STRING, "block"),
									"Main", new int[] {29,12,36,9},
									new AtIndex(
										new Variable(Type.LIST, "blocks"),
										new Variable(Type.INTEGER, "i"),
										Type.STRING
									)
								),
								new Subgoal(
									"Main", new int[] {31,12,36,9},
									new Goal(
										new Predicate("holding", new Term[] {
											new Variable(Type.STRING, "block")
										})
									)
								),
								new Subgoal(
									"Main", new int[] {32,12,36,9},
									new Goal(
										new Predicate("On", new Term[] {
											new Variable(Type.STRING, "block"),
											new Variable(Type.STRING, "X")
										})
									)
								),
								new Assignment(
									new Variable(Type.STRING, "X"),
									"Main", new int[] {34,12,36,9},
									new Variable(Type.STRING, "block")
								),
								new MinusMinus(
									new Variable(Type.INTEGER, "i"),
									"Main", new int[] {35,12,35,15}
								)
							}
						)
					),
					new ModuleCall("C",
						"Main", new int[] {37,8,37,37},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Tower Completed!")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Main","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {42,9,42,62},
			new GoalEvent('+',
				new Goal(
					new Predicate("holding", new Term[] {
						new Variable(Type.STRING, "X",false)
					})
				)
			),
			new AND(
				new NOT(
					new ModuleFormula("ei",
						new Predicate("holding", new Term[] {
							new Variable(Type.STRING, "Y",false)
						}),
						new ModuleFormulaAdaptor() {
							public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
								return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
							}
						}
					)
				),
				new Predicate("free", new Term[] {
					new Variable(Type.STRING, "X")
				})
			),
			new Block(
				"Main", new int[] {42,61,45,5},
				new Statement[] {
					new ModuleCall("ei",
						"Main", new int[] {43,8,43,20},
						new Predicate("pickup", new Term[] {
							new Variable(Type.STRING, "X")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Main","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Wait(
						"Main", new int[] {44,8,45,5},
						new ModuleFormula("ei",
							new Predicate("holding", new Term[] {
								new Variable(Type.STRING, "X")
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {48,9,48,59},
			new GoalEvent('+',
				new Goal(
					new Predicate("On", new Term[] {
						new Variable(Type.STRING, "X",false),
						new Variable(Type.STRING, "Y",false)
					})
				)
			),
			new AND(
				new ModuleFormula("ei",
					new Predicate("holding", new Term[] {
						new Variable(Type.STRING, "X")
					}),
					new ModuleFormulaAdaptor() {
						public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
							return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
						}
					}
				),
				new Predicate("free", new Term[] {
					new Variable(Type.STRING, "Y")
				})
			),
			new Block(
				"Main", new int[] {48,58,51,5},
				new Statement[] {
					new ModuleCall("ei",
						"Main", new int[] {49,8,49,24},
						new Predicate("putdown", new Term[] {
							new Variable(Type.STRING, "X"),
							new Variable(Type.STRING, "Y")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Main","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					),
					new Wait(
						"Main", new int[] {50,8,51,5},
						new ModuleFormula("ei",
							new Predicate("on", new Term[] {
								new Variable(Type.STRING, "X"),
								new Variable(Type.STRING, "Y")
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {53,9,53,37},
			new GoalEvent('+',
				new Goal(
					new Predicate("random_tower", new Term[] {
						new Variable(Type.LIST, "blocks",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {53,36,80,5},
				new Statement[] {
					new Declaration(
						new Variable(Type.INTEGER, "high"),
						"Main", new int[] {55,8,80,5},
						Primitive.newPrimitive(1)
					),
					new Declaration(
						new Variable(Type.STRING, "Y"),
						"Main", new int[] {56,8,80,5},
						Primitive.newPrimitive("table")
					),
					new While(
						"Main", new int[] {57,8,80,5},
						new Comparison("<",
							new Variable(Type.INTEGER, "high"),
							new Count(
								new Variable(Type.LIST, "blocks")
							)
						),
						new Block(
							"Main", new int[] {57,40,77,9},
							new Statement[] {
								new Declaration(
									new Variable(Type.INTEGER, "counter"),
									"Main", new int[] {59,12,77,9},
									Operator.newOperator('+',
										Primitive.newPrimitive(0),
										new Brackets(
											Operator.newOperator('%',
												new ModuleTerm("math", Type.INTEGER,
													new Predicate("randomInt", new Term[] {}),
													new ModuleTermAdaptor() {
														public Object invoke(Intention intention, Predicate predicate) {
															return ((astra.lang.Math) intention.getModule("Main","math")).randomInt(
															);
														}
														public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
															return ((astra.lang.Math) visitor.agent().getModule("Main","math")).randomInt(
															);
														}
													}
												),
												new Brackets(
													Operator.newOperator('+',
														new Count(
															new Variable(Type.LIST, "blocks")
														),
														Primitive.newPrimitive(1)
													)
												)
											)
										)
									)
								),
								new While(
									"Main", new int[] {60,12,77,9},
									new Comparison(">",
										new Variable(Type.INTEGER, "counter"),
										Primitive.newPrimitive(0)
									),
									new Block(
										"Main", new int[] {60,29,76,13},
										new Statement[] {
											new ForAll(
												"Main", new int[] {61,16,61,42},
												new Variable(Type.STRING, "X",false),
												new Variable(Type.LIST, "blocks"),
												new Block(
													"Main", new int[] {61,43,76,13},
													new Statement[] {
														new If(
															"Main", new int[] {63,20,75,17},
															new Predicate("free", new Term[] {
																new Variable(Type.STRING, "X")
															}),
															new Block(
																"Main", new int[] {63,31,74,21},
																new Statement[] {
																	new Subgoal(
																		"Main", new int[] {64,24,74,21},
																		new Goal(
																			new Predicate("holding", new Term[] {
																				new Variable(Type.STRING, "X")
																			})
																		)
																	),
																	new Subgoal(
																		"Main", new int[] {65,24,74,21},
																		new Goal(
																			new Predicate("On", new Term[] {
																				new Variable(Type.STRING, "X"),
																				new Variable(Type.STRING, "Y")
																			})
																		)
																	),
																	new Assignment(
																		new Variable(Type.STRING, "Y"),
																		"Main", new int[] {66,24,74,21},
																		new Variable(Type.STRING, "X")
																	),
																	new MinusMinus(
																		new Variable(Type.INTEGER, "counter"),
																		"Main", new int[] {67,24,67,34}
																	),
																	new PlusPlus(
																		new Variable(Type.INTEGER, "high"),
																		"Main", new int[] {68,24,68,31}
																	),
																	new If(
																		"Main", new int[] {71,24,74,21},
																		new Comparison(">",
																			new Variable(Type.INTEGER, "high"),
																			new Count(
																				new Variable(Type.LIST, "blocks")
																			)
																		),
																		new Block(
																			"Main", new int[] {71,53,73,25},
																			new Statement[] {
																				new Assignment(
																					new Variable(Type.INTEGER, "counter"),
																					"Main", new int[] {72,28,73,25},
																					Primitive.newPrimitive(0)
																				)
																			}
																		)
																	)
																}
															)
														)
													}
												)
											)
										}
									)
								)
							}
						)
					),
					new ModuleCall("C",
						"Main", new int[] {78,8,78,44},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Random Tower Completed!")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Main","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {82,9,82,30},
			new GoalEvent('+',
				new Goal(
					new Predicate("floor", new Term[] {
						new Variable(Type.LIST, "blocks",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {82,29,95,5},
				new Statement[] {
					new Declaration(
						new Variable(Type.INTEGER, "down"),
						"Main", new int[] {83,8,95,5},
						Primitive.newPrimitive(1)
					),
					new While(
						"Main", new int[] {84,8,95,5},
						new Comparison("<",
							new Variable(Type.INTEGER, "down"),
							new Count(
								new Variable(Type.LIST, "blocks")
							)
						),
						new Block(
							"Main", new int[] {84,40,92,9},
							new Statement[] {
								new ForAll(
									"Main", new int[] {85,12,85,38},
									new Variable(Type.STRING, "X",false),
									new Variable(Type.LIST, "blocks"),
									new Block(
										"Main", new int[] {85,39,92,9},
										new Statement[] {
											new If(
												"Main", new int[] {86,16,91,13},
												new AND(
													new NOT(
														new ModuleFormula("ei",
															new Predicate("on", new Term[] {
																new Variable(Type.STRING, "X"),
																Primitive.newPrimitive("table")
															}),
															new ModuleFormulaAdaptor() {
																public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																	return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
																}
															}
														)
													),
													new Predicate("free", new Term[] {
														new Variable(Type.STRING, "X")
													})
												),
												new Block(
													"Main", new int[] {86,48,90,17},
													new Statement[] {
														new Subgoal(
															"Main", new int[] {87,20,90,17},
															new Goal(
																new Predicate("holding", new Term[] {
																	new Variable(Type.STRING, "X")
																})
															)
														),
														new Subgoal(
															"Main", new int[] {88,20,90,17},
															new Goal(
																new Predicate("On", new Term[] {
																	new Variable(Type.STRING, "X"),
																	Primitive.newPrimitive("table")
																})
															)
														),
														new PlusPlus(
															new Variable(Type.INTEGER, "down"),
															"Main", new int[] {89,20,89,26}
														)
													}
												)
											)
										}
									)
								)
							}
						)
					),
					new ModuleCall("C",
						"Main", new int[] {93,8,93,46},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Wait for new random tower")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Main","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {99,9,99,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {99,27,131,5},
				new Statement[] {
					new ModuleCall("ei",
						"Main", new int[] {100,8,100,52},
						new Predicate("launch", new Term[] {
							Primitive.newPrimitive("hw"),
							Primitive.newPrimitive("dependency/tower-1.3.0.jar")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Main","ei")).launch(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("ei",
						"Main", new int[] {101,8,101,17},
						new Predicate("init", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Main","ei")).init(
								);
							}
						}
					),
					new ModuleCall("ei",
						"Main", new int[] {102,8,102,18},
						new Predicate("start", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Main","ei")).start(
								);
							}
						}
					),
					new ModuleCall("ei",
						"Main", new int[] {105,8,105,26},
						new Predicate("link", new Term[] {
							Primitive.newPrimitive("gripper")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Main","ei")).link(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("C",
						"Main", new int[] {108,8,108,64},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Press New Block until block C is created...")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Main","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Wait(
						"Main", new int[] {109,8,131,5},
						new ModuleFormula("ei",
							new Predicate("block", new Term[] {
								Primitive.newPrimitive("c")
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						)
					),
					new ModuleCall("C",
						"Main", new int[] {110,8,110,53},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Block C created. Building tower!")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Main","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"Main", new int[] {111,8,131,5},
						new Goal(
							new Predicate("tower", new Term[] {
								new ListTerm(new Term[] {
									Primitive.newPrimitive("a"),
									Primitive.newPrimitive("d")
								})
							})
						)
					),
					new Wait(
						"Main", new int[] {114,8,131,5},
						new Predicate("tower", new Term[] {
							new ListTerm(new Term[] {
								Primitive.newPrimitive("a"),
								Primitive.newPrimitive("d")
							})
						})
					),
					new ModuleCall("C",
						"Main", new int[] {115,8,115,46},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Add until block f exists!")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Main","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Wait(
						"Main", new int[] {116,8,131,5},
						new ModuleFormula("ei",
							new Predicate("block", new Term[] {
								Primitive.newPrimitive("f")
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						)
					),
					new Subgoal(
						"Main", new int[] {118,8,131,5},
						new Goal(
							new Predicate("tower", new Term[] {
								new ListTerm(new Term[] {
									Primitive.newPrimitive("c"),
									Primitive.newPrimitive("e"),
									Primitive.newPrimitive("b"),
									Primitive.newPrimitive("f")
								})
							})
						)
					),
					new Wait(
						"Main", new int[] {120,8,131,5},
						new Predicate("tower", new Term[] {
							new ListTerm(new Term[] {
								Primitive.newPrimitive("c"),
								Primitive.newPrimitive("e"),
								Primitive.newPrimitive("b"),
								Primitive.newPrimitive("f")
							})
						})
					),
					new Wait(
						"Main", new int[] {122,8,131,5},
						new ModuleFormula("ei",
							new Predicate("block", new Term[] {
								Primitive.newPrimitive("g")
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.EIS) visitor.agent().getModule("Main","ei")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						)
					),
					new Declaration(
						new Variable(Type.INTEGER, "forev"),
						"Main", new int[] {124,8,131,5},
						Primitive.newPrimitive(0)
					),
					new While(
						"Main", new int[] {125,8,131,5},
						new Comparison("==",
							new Variable(Type.INTEGER, "forev"),
							Primitive.newPrimitive(0)
						),
						new Block(
							"Main", new int[] {125,23,129,9},
							new Statement[] {
								new Subgoal(
									"Main", new int[] {126,12,129,9},
									new Goal(
										new Predicate("random_tower", new Term[] {
											new ListTerm(new Term[] {
												Primitive.newPrimitive("a"),
												Primitive.newPrimitive("b"),
												Primitive.newPrimitive("c"),
												Primitive.newPrimitive("d"),
												Primitive.newPrimitive("e"),
												Primitive.newPrimitive("f"),
												Primitive.newPrimitive("g")
											})
										})
									)
								),
								new Subgoal(
									"Main", new int[] {127,12,129,9},
									new Goal(
										new Predicate("floor", new Term[] {
											new ListTerm(new Term[] {
												Primitive.newPrimitive("a"),
												Primitive.newPrimitive("b"),
												Primitive.newPrimitive("c"),
												Primitive.newPrimitive("d"),
												Primitive.newPrimitive("e"),
												Primitive.newPrimitive("f"),
												Primitive.newPrimitive("g")
											})
										})
									)
								),
								new ModuleCall("sys",
									"Main", new int[] {128,12,128,27},
									new Predicate("sleep", new Term[] {
										Primitive.newPrimitive(20000)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return false;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.System) intention.getModule("Main","sys")).sleep(
												(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {134,9,134,30},
			new ModuleEvent("ei",
				"$eis",
				new Predicate("event", new Term[] {
					new Variable(Type.FUNCTION, "Y",false)
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.EIS) agent.getModule("Main","ei")).event(
							"+",
							predicate.getTerm(0)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {134,29,136,5},
				new Statement[] {
					new ModuleCall("C",
						"Main", new int[] {135,8,135,27},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Y: "),
								new Variable(Type.FUNCTION, "Y")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Main","C")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {138,9,138,29},
			new GoalEvent('+',
				new Goal(
					new Predicate("pickup", new Term[] {
						new Variable(Type.STRING, "X",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {138,28,141,5},
				new Statement[] {
					new ModuleCall("ei",
						"Main", new int[] {139,8,139,20},
						new Predicate("pickup", new Term[] {
							new Variable(Type.STRING, "X")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.EIS) intention.getModule("Main","ei")).auto_action(intention,evaluate(intention,predicate));
							}
						}
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
		agent.addSensorAdaptor(new SensorAdaptor() {
			public void sense(astra.core.Agent agent) {
				((astra.lang.EIS) agent.getModule("Main","ei")).sense();
			}
		});

	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("ei",astra.lang.EIS.class,agent);
		fragment.addModule("C",astra.lang.Console.class,agent);
		fragment.addModule("math",astra.lang.Math.class,agent);
		fragment.addModule("sys",astra.lang.System.class,agent);
		return fragment;
	}

	public static void main(String[] args) {
		Scheduler.setStrategy(new TestSchedulerStrategy());
		ListTerm argList = new ListTerm();
		for (String arg: args) {
			argList.add(Primitive.newPrimitive(arg));
		}

		String name = java.lang.System.getProperty("astra.name", "main");
		try {
			astra.core.Agent agent = new Main().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
